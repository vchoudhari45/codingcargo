package com.vc.easy

object L136 {
  def singleNumber(nums: Array[Int]): Int = {
    var res = 0
    nums.foreach(x => res = res ^ x)
    res
  }
}
