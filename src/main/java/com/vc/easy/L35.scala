package com.vc.easy

object L35 {
  def searchInsert(arr: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = arr.length - 1
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if(arr(mid) < target) lo = mid + 1
      else if(arr(mid) > target) hi = mid - 1
      else return mid
    }
    lo
  }
}
