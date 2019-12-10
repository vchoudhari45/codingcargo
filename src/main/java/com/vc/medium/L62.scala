package com.vc.medium

object L62 {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m, n)
    (0 until m).foreach(i => {
      (0 until n).foreach(j => {
        if(i == 0 || j == 0) dp(i)(j) = 1
        else dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
      })
    })
    dp(m - 1)(n - 1)
  }
}