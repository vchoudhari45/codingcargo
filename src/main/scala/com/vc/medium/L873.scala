package com.vc.medium

object L873 {
  def lenLongestFibSubseq(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val index = new mutable.HashMap[Int, Int]()
    val n = arr.length
    val dp = Array.ofDim[Int](n, n)
    arr.indices.foreach(i => {
      index.put(arr(i), i)
    })
    var res = 0
    (0 until n).foreach(i => {
      (0 until i).foreach(j => {
        val k = index.getOrElse(arr(i) - arr(j), -1)
        if(k >= 0 && k < j) {
          val cand = if(dp(j)(k) > 2) dp(j)(k) + 1 else 3
          dp(i)(j) = cand
          res = Math.max(res, cand)
        }
      })
    })
    if(res > 2) res else 0
  }
}
