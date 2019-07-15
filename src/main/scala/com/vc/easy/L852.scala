package com.vc.easy

object L852 {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    var l = 0
    var h = arr.length - 1
    while(l <= h) {
      val mid = l + (h - l) / 2
      if(arr(mid) < arr(mid + 1)) {
        l = mid + 1
      }
      else h = mid - 1
    }
    l
  }
}
