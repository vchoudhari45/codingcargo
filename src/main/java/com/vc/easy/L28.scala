package com.vc.easy

//KMP
object L28 {
  def strStr(haystack: String, needle: String): Int = {
    val hn = haystack.length
    val nn = needle.length

    if(hn == 0 && nn == 0) return 0
    else if(hn == 0) return -1
    else if(nn == 0) return 0

    var i = 1
    var j = 0
    val s = needle + "$" + haystack
    val n = s.length
    val arr = new Array[Int](n)

    while(i < n) {
      if(s(i) == s(j)) {
        j += 1
        arr(i) = j
        if(arr(i) == nn) return i - 2 * nn
        i += 1
      }
      else {
        if(j == 0) i += 1
        else j = arr(j - 1)
      }
    }
    -1
  }
}
