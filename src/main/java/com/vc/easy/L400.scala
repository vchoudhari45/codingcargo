package com.vc.easy

object L400 {
  def findNthDigit(n: Int): Int = {
    var start = 1
    var len = 1
    var count = 9.toLong

    var m = n.toLong
    while(m > len * count) {
      m -= len * count
      len += 1
      start *= 10
      count *= 10
    }

    start += (m.toInt - 1) / len
    start.toString()((m.toInt - 1) % len) - '0'
  }
}
