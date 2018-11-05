package com.vc.easy

object L693 {
  def hasAlternatingBits(n: Int): Boolean = {
    var m = n >> 1
    m = n ^ m
    (m & (m + 1)) == 0
  }
}
