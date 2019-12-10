package com.vc.hard

object L214 {
  def shortestPalindrome(s: String): String = {
    //"aacecaaa#aaacecaa"
    // 01000121012234567

    //"abcd#dcba"
    // 000000001

    val sNew = s + "#" + s.reverse
    val n = sNew.length
    val arr = new Array[Int](n)

    //KMP
    var start = 0
    var end = 1
    while(end < n) {
      if(sNew(end) == sNew(start)) {
        arr(end) = start + 1
        end += 1
        start += 1
      }
      else {
        if(start == 0) {
          arr(end) = 0
          end += 1
        }
        else start = arr(start - 1)
      }
    }
    s.substring(arr(n - 1)).reverse + s
  }
}