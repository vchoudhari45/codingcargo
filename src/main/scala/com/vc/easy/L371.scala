package com.vc.easy

object L371 {
  def getSum(a: Int, b: Int): Int = {
    var x = a
    var y = b
    while(y != 0) {
      val carry = x & y
      x = x ^ y
      y = carry << 1
    }
    x
  }
}
