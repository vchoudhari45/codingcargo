package com.vc.easy

object L724 {
  def pivotIndex(nums: Array[Int]): Int = {
    var left = 0
    var i = 0
    val n = nums.length
    val sum = nums.sum
    while(i < n) {
      if(sum - left - nums(i) == left) return i
      left += nums(i)
      i += 1
    }
    -1
  }
}
