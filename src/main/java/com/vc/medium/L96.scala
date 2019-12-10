package com.vc.medium

object L96 {
  def numTrees(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    (2 to n).foreach(i => {
      (1 to i).foreach(j => {
        dp(i) += dp(i - j) * dp(j - 1)
      })
    })
    dp(n)
  }
}
