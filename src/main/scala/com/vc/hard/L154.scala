package com.vc.hard

object L154 {
  def findMin(arr: Array[Int]): Int = {
    var lo = 0
    var hi = arr.length - 1
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if(arr(mid) < arr(hi)) {
        hi = mid
      }
      else if(arr(mid) > arr(hi)) {
        lo = mid + 1
      }
      else hi -= 1
    }
    arr(lo)
  }
}