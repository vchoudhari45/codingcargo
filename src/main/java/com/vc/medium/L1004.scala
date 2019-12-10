package com.vc.medium

object L1004 {
  def longestOnes(A: Array[Int], K: Int): Int = {
    var i = 0
    var j = 0
    var k = K
    val n = A.length
    while(i < n) {
      if(A(i) == 0) k -= 1
      if(k < 0) {
        if(A(j) == 0) k += 1
        j += 1
      }
      i += 1
    }
    i - j
  }
}