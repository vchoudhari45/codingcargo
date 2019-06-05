package com.vc.medium

object L926 {
  def minFlipsMonoIncr(s: String): Int = {
    var flips = 0
    var ones = 0
    val n = s.length
    var i = 0
    while(i < n) {
      if(s(i) == '0') {
        if(ones > 0) flips += 1
      }
      else ones += 1
      if(flips > ones) flips = ones
      i += 1
    }
    flips
  }
}
