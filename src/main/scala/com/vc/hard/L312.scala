package com.vc.hard

object L312 {
  def maxCoins(nums: Array[Int]): Int = {
    val n = nums.length
    if(n == 0) return 0

    val dp = Array.ofDim[Int](n, n)
    (0 until n).foreach(len => {
      (0 until n - len).foreach(i => {
        val j = i + len
        val leftValue = if(i == 0) 1 else nums(i - 1)
        val rightValue = if(j == n - 1) 1 else nums(j + 1)

        (i to j).foreach(k => {
          val before = if(i < k) dp(i)(k - 1) else 0
          val after = if(k < j) dp(k + 1)(j) else 0
          dp(i)(j) = Math.max(dp(i)(j), before + after + leftValue * nums(k) * rightValue)
        })
      })
    })
    dp.indices.foreach(i => {
      println(dp(i).mkString(", "))
    })
    dp(0)(n - 1)
  }
}
