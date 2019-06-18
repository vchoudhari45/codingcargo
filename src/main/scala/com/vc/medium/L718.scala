package com.vc.medium

object L718 {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    val n = A.length
    val m = B.length
    val dp = Array.ofDim[Int](n + 1, m + 1)
    var res = 0
    (1 to n).foreach(i => {
      (1 to m).foreach(j => {
        if(A(i - 1) == B(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
          res = Math.max(res, dp(i)(j))
        }
      })
    })
    res
  }
}
