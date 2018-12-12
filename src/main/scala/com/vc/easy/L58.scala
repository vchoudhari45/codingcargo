package com.vc.easy

object L58 {
  def lengthOfLastWord(s: String): Int = {
    val str = s.trim
    val n = str.length
    var i = n - 1
    var res = 0
    while(i >= 0) {
      if(str(i) == ' ') return res
      res += 1
      i -= 1
    }
    res
  }
}
