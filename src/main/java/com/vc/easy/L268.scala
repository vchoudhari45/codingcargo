package com.vc.easy

object L268 {
  def missingNumber(nums: Array[Int]): Int = {
    val n = nums.length
    val sum = n * (n + 1) / 2
    sum - nums.sum
  }
}
