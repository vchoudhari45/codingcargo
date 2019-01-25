package com.vc.medium

object L877 {
  def stoneGame(arr: Array[Int]): Boolean = {
    val n = arr.length
    val dp = new Array[Int](n)
    dp.indices.foreach(i => dp(i) = arr(i))
    (1 until n).foreach(d => {
      (0 until n - d).foreach(i => {
        dp(i) = Math.max(arr(i) - dp(i), arr(i + d) - dp(i + d - 1))
      })
    })
    dp(0) > 0
  }
}
