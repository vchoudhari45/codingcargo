package com.vc.easy

object L485 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    val n = nums.length
    var i = 0
    var res = 0
    var count = 0
    while(i < n) {
      if(nums(i) == 1) {
        count += 1
        res = Math.max(count, res)
      }
      else count = 0
      i += 1
    }
    res
  }
}
