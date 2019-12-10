package com.vc.easy

object L258 {
  def addDigits(num: Int): Int = {
    var n = num
    var m = n
    while(n > 9) {
      m = n
      n = 0
      while(m != 0) {
        n += m % 10
        m = m / 10
      }
    }
    n
  }
}
