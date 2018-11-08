package com.vc.easy

object L283 {
  def moveZeroes(nums: Array[Int]): Unit = {
    val n = nums.length
    var i = 0
    var j = 0
    while(i < n) {
      if(nums(i) != 0) {
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }
    (j until n).foreach(i => nums(i) = 0)
  }
}
