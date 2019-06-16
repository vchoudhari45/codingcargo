package com.vc.medium

object L487 {
  def findMaxConsecutiveOnes(arr: Array[Int]): Int = {
    var l, h, max = 0
    val n = arr.length
    val k = 1
    var zeros = 0
    while(h < n) {
      if(arr(h) == 0) zeros += 1
      while(zeros > k) {
        if(arr(l) == 0) zeros -= 1
        l += 1
      }
      max = Math.max(max, h - l + 1)
      h += 1
    }
    max
  }
}
