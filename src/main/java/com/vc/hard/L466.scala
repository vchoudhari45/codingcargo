package com.vc.hard

object L466 {
  def getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int = {
    var count1 = 0
    var count2 = 0
    var i = 0
    var j = 0
    val n = s1.length
    val m = s2.length
    //Idea is to use length of s1 equal to n1 times and see how many length of s2 we were able to fit
    while(count1 < n1) {
      if(s1(i) == s2(j)) {
        i += 1
        j += 1
      }
      else i += 1

      if(i == n) {
        count1 += 1
        i = 0
      }

      if(j == m) {
        count2 += 1
        j = 0
      }
    }
    count2 / n2
  }
}
