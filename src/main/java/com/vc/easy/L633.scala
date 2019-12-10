package com.vc.easy

object L633 {
  def judgeSquareSum(c: Int): Boolean = {
    var lo = 0
    var hi = Math.sqrt(c).toInt
    while(lo <= hi) {
      val mid = lo * lo + hi * hi
      if(mid < c) lo += 1
      else if(mid > c) hi -= 1
      else return true
    }
    false
  }
}
