package com.vc.easy

object L680 {
  def validPalindrome(s: String): Boolean = {
    var i = 0
    var j = s.length - 1
    while(i < j) {
      if(s(i) != s(j)) {
        return isValid(i + 1, j, s) || isValid(i, j - 1, s)
      }
      i += 1
      j -= 1
    }
    true
  }

  def isValid(start:Int, end: Int, s: String): Boolean = {
    var i = start
    var j = end
    while(i < j) {
      if(s(i) != s(j)) return false
      i += 1
      j -= 1
    }
    true
  }
}
