package com.vc.easy

object L125 {
  def isPalindrome(s: String): Boolean = {
    def isAlphaNumeric(ch: Char): Boolean = {
      (ch >= 'A' && ch <= 'Z') ||  (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')
    }

    var i = 0
    var j = s.length - 1
    while(i < j) {
      while(i < j && !isAlphaNumeric(s(i))) i += 1
      while(i < j && !isAlphaNumeric(s(j))) j -= 1

      if(s(i).toLower != s(j).toLower) return false
      i += 1
      j -= 1
    }
    true
  }
}
