package com.vc.hard

object L1121 {
  def canDivideIntoSubsequences(arr: Array[Int], K: Int): Boolean = {
    var groups = 1
    var i = 0
    val n = arr.length
    var duplicates = 1
    while(i < n - 1) {
      if(arr(i) == arr(i + 1)) {
        duplicates += 1
        groups = Math.max(duplicates, groups)
      }
      else duplicates = 1
      i += 1
    }
    groups * K <= arr.length
  }
}
