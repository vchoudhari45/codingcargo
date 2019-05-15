package com.vc.medium

object L651 {
  def maxA(N: Int): Int = {
    val dp = new Array[Int](N + 1)
    dp.indices.foreach(i => {
      dp(i) = i //by only pressing A
      (0 to i - 3).foreach(j => {
        dp(i) = Math.max(dp(i), dp(j) * (i - j - 1))
      })
    })
    dp(N)
  }
}
