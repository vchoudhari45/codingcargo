package com.vc.medium

object L413 {
  def numberOfArithmeticSlices(arr: Array[Int]): Int = {
    val n = arr.length
    var cur = 0
    var sum = 0
    (2 until n).foreach(i => {
      if(arr(i - 2) - arr(i - 1) == arr(i - 1) - arr(i)) {
        cur += 1
        sum += cur
      }
      else cur = 0
    })
    sum
  }
}
