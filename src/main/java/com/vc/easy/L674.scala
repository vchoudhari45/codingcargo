package com.vc.easy

object L674 {
  def findLengthOfLCIS(arr: Array[Int]): Int = {
    var i = 0
    var res = 0
    var count = 0
    val n = arr.length
    while(i < n) {
      if(i != 0 && arr(i - 1) < arr(i)) count += 1
      else {
        res = Math.max(count, res)
        count = 1
      }
      i += 1
    }
    Math.max(res, count)
  }
}
