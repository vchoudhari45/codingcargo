package com.vc.easy

object L198 {
  def rob(arr: Array[Int]): Int = {
    val n = arr.length
    if(n == 0) return 0
    var i = 1
    while(i < n) {
      arr(i) = Math.max((if(i - 2 >= 0) arr(i - 2) else 0) + arr(i), arr(i - 1))
      i += 1
    }
    arr.max
  }
}