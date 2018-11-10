package com.vc.easy

object L696 {
  def countBinarySubstrings(s: String): Int = {
    var i = 1
    var res = 0
    val n = s.length
    var prev = 0
    var current = 1
    while(i < n) {
      if(s(i - 1) == s(i)) current += 1
      else {
        prev = current
        current = 1
      }
      if(prev >= current) res += 1
      i += 1
    }
    res
  }
}
