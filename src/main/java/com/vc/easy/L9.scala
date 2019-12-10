package com.vc.easy

object L9 {
  def isPalindrome(x: Int): Boolean = {
    if(x < 0) return false
    var xVar = x
    var res = 0
    while(xVar != 0) {
      res = res * 10 + xVar % 10
      xVar = xVar / 10
    }
    res == x
  }
}
