package com.vc.easy

object L53 {
  def maxSubArray(nums: Array[Int]): Int = {
    var i = 1
    val n = nums.length
    while(i < n) {
      nums(i) = Math.max(nums(i), nums(i) + nums(i - 1))
      i += 1
    }
    nums.max
  }
}
