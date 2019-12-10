package com.vc.medium

object L343 {
  def integerBreak(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    //1 can't be split, so start from 2
    (2 to n).foreach(i => {
      //Try all the possible combination starting with 1 & number - 1
      (1 until i).foreach(j => {
        dp(i) = Math.max(dp(i), Math.max(j, dp(j)) * Math.max(i - j, dp(i - j)))
      })
    })
    dp(n)
  }
}
