package com.vc.easy

object L868 {
  def binaryGap(N: Int): Int = {
    var prev = -1
    var current = 0
    var res = 0
    var n = N
    while(n != 0) {
      if((n & 1) == 1){
        if(prev != -1) res = Math.max(res, current - prev)
        prev = current
      }
      current += 1
      n = n >> 1
    }
    res
  }
}
