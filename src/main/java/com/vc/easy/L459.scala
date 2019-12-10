package com.vc.easy

object L459 {
  def repeatedSubstringPattern(s: String): Boolean = {
    val n = s.length
    var i = 1
    var j = 0
    val arr = new Array[Int](n)
    while(i < n) {
      if(s(i) == s(j)) {
        arr(i) = j + 1
        i += 1
        j += 1
      }
      else {
        if(j == 0) i += 1
        else j = arr(j - 1)
      }
    }
    arr(n - 1) != 0 && n % (n - arr(n - 1)) == 0
  }
}