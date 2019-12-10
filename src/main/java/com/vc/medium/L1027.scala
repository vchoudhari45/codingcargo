package com.vc.medium

object L1027 {
  def longestArithSeqLength(A: Array[Int]): Int = {
    import scala.collection.mutable
    val dp = new Array[mutable.HashMap[Int, Int]](A.length)
    val n = A.length
    var res = 0
    (0 until n).foreach(i => {
      dp(i) = new mutable.HashMap[Int, Int]()
      (0 until i).foreach(j => {
        val d = A(j) - A(i)
        dp(i).put(d, dp(j).getOrElse(d, 1) + 1)
        res = Math.max(res, dp(i)(d))
      })
    })
    res
  }
}
