package com.vc

object L665 {
  def checkPossibility(nums: Array[Int]): Boolean = {
    val n = nums.length
    var i = 1
    var count = 0
    while(i < n){
      val prev = nums(i - 1)
      val current = nums(i)
      if(prev > current){
        count += 1
        if(count > 1) return false
        if(i - 2 < 0 || nums(i - 2) <= nums(i)) nums(i - 1) = nums(i)
        else nums(i) = nums(i - 1)
      }
      i += 1
    }
    true
  }
}
