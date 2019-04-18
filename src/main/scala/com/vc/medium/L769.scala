package com.vc.medium

object L769 {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    var res = 0
    var max = 0
    var i = 0
    val n = arr.length
    while(i < n) {
      max = Math.max(max, arr(i))
      if(i == max) res += 1
      i += 1
    }
    res
  }
}
