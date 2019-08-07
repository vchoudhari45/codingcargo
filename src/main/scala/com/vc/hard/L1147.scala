package com.vc.hard

object L1147 {
  def longestDecomposition(text: String): Int = {
    val n = text.length
    var res = 0
    var i = 0
    var left = ""
    var right = ""
    while(i < n) {
      left += text(i)
      right = text(n - i - 1) + right
      if(left == right) {
        left = ""
        right = ""
        res += 1
      }
      i += 1
    }
    res
  }
}