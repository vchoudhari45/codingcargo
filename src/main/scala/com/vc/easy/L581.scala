package com.vc.easy

object L581 {
  def findUnsortedSubarray(arr: Array[Int]): Int = {
    // 1 3 2 4
    val n = arr.length
    var i = 0
    var min = arr(n - 1)
    var max = arr(0)
    var r = -2
    var l = -1
    while(i < n) {
      max = Math.max(max, arr(i)) // max found so far from the start of the array
      if(max > arr(i)) {          // check if max idx is index of the current element else we need to swap
        r = i
      }

      min = Math.min(min, arr(n - i - 1)) // min found so far from the end of the array
      if(min < arr(n - i - 1)) {
        l = n - i - 1
      }
      i += 1
    }
    r - l + 1
  }
}
