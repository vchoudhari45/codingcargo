package com.vc.hard

object L135 {
  def candy(arr: Array[Int]): Int = {
    val n = arr.length

    //Go from left to right
    var i = 1
    val left = Array.fill(n)(1)
    while(i < n) {
      if(arr(i) > arr(i - 1)) {
        left(i) = left(i - 1) + 1
      }
      i += 1
    }

    //Go from right to left
    i = n - 1
    val right = Array.fill(n)(1)
    while(i > 0) {
      if(arr(i - 1) > arr(i)) {
        right(i - 1) = right(i) + 1
      }
      i -= 1
    }

    //Take max at each position
    val total = new Array[Int](n)
    i = 0
    while(i < n) {
      total(i) = Math.max(left(i), right(i))
      i += 1
    }
    total.sum
  }
}