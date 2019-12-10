package com.vc.hard

object L768 {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    val n = arr.length
    if(n == 0) return 0

    val maxLeft = new Array[Int](n)
    var i = 1
    maxLeft(0) = arr(0)
    while(i < n) {
      maxLeft(i) = Math.max(maxLeft(i - 1), arr(i))
      i += 1
    }

    val minRight = new Array[Int](n)
    i = n - 2
    minRight(n - 1) = arr(n - 1)
    while(i >= 0) {
      minRight(i) = Math.min(minRight(i + 1), arr(i))
      i -= 1
    }

    i = 0
    var res = 0
    while(i < n - 1) {
      if(maxLeft(i) <= minRight(i + 1)) res += 1
      i += 1
    }
    res + 1
  }
}
