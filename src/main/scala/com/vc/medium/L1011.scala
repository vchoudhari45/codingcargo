package com.vc.medium

object L1011 {
  def shipWithinDays(weights: Array[Int], D: Int): Int = {
    var left = 0
    var right = 0
    weights.foreach(w => {
      left = Math.max(w, left)
      right += w
    })
    while(left < right) {
      val mid = left + (right - left) / 2
      var cur = 0
      var need = 1
      weights.foreach(w => {
        if(cur + w > mid) {
          need += 1
          cur = 0
        }
        cur += w
      })
      if(need > D) left += 1
      else right = mid
    }
    left
  }
}
