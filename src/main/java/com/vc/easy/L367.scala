package com.vc.easy

object L367 {
  def isPerfectSquare(num: Int): Boolean = {
    if(num == 1) return true
    var lo = 0.toLong
    var hi = (num / 2).toLong
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      val square = mid * mid
      if(square == num) return true
      else if(square > num) hi = mid - 1
      else lo = mid + 1
    }
    false
  }
}
