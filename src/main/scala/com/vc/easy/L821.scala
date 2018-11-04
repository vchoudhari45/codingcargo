package com.vc.easy

object L821 {
  def shortestToChar(s: String, c: Char): Array[Int] = {
    val n = s.length
    val arr = new Array[Int](n)
    var pos = -n
    var i = 0
    while(i < n) {
      if(s(i) == c) pos = i
      arr(i) = i - pos
      i += 1
    }
    i = n - 1
    while(i >= 0) {
      if(s(i) == c) pos = i
      arr(i) = Math.min(arr(i), Math.abs(i - pos))
      i -= 1
    }
    arr
  }
}
