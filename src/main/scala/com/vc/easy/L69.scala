package com.vc.easy

object L69 {
  def mySqrt(x: Int): Int = {
    var lo = 1
    var hi = x
    var ans = 0
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      val res = x / mid
      if(res > mid) {
        lo = mid + 1
        ans = mid
      }
      else if(res < mid) {
        hi = mid - 1
      }
      else return mid
    }
    ans
  }
}
