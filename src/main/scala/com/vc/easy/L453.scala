package com.vc.easy

object L453 {
  def minMoves(nums: Array[Int]): Int = {
    val min = nums.min
    var res = 0
    nums.foreach(x => {
      res += x - min
    })
    res
  }
}
