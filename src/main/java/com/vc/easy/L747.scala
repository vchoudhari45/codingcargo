package com.vc.easy

object L747 {
  def dominantIndex(nums: Array[Int]): Int = {
    var firstMaxIdx = -1
    var firstMax = Int.MinValue
    var secondMax =Int.MinValue
    var i = 0
    val n = nums.length
    while(i < n) {
      if(nums(i) > firstMax) {
        val tmp = firstMax
        firstMax = nums(i)
        firstMaxIdx = i
        secondMax = tmp
      }
      else if(nums(i) > secondMax) secondMax = nums(i)
      i += 1
    }
    if(secondMax * 2 <= firstMax) firstMaxIdx else -1
  }
}
