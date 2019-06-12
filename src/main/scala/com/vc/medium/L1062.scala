package com.vc.medium

object L1062 {
  def longestRepeatingSubstring(S: String): Int = {
    val n = S.length
    val dp = Array.ofDim[Int](n + 1, n + 1)
    var res = 0
    (1 to n).foreach(i => {
      (i + 1 to n).foreach(j => {
        if(S(i - 1) == S(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
          res = Math.max(res, dp(i)(j))
        }
      })
    })
    res
  }
}
