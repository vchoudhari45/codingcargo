package com.vc.easy

object L896 {
  def isMonotonic(arr: Array[Int]): Boolean = {
    val n = arr.length
    var asc = true
    var desc = true
    var i = 1
    while(i < n) {
      if(arr(i) > arr(i - 1)) {
        desc = false
        if(!asc) return false
      }
      if(arr(i) < arr(i - 1)) {
        asc = false
        if(!desc) return false
      }
      i += 1
    }
    true
  }
}
