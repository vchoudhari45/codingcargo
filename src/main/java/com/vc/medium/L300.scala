package com.vc.medium

object L300 {
  def lengthOfLIS(arr: Array[Int]): Int = {
    /**
        [10,9,2,5,3,7,101,18]
        [ 1,1,1,1,1,1, 1,  1]
      */
    val n = arr.length
    if(n == 0) return 0
    val dp = Array.fill(n)(1)
    (1 until n).foreach(i => {
      (0 until i).foreach(j => {
        if(arr(i) > arr(j)) {
          dp(i) = Math.max(dp(i), dp(j) + 1)
        }
      })
    })
    dp.max
  }
}