package com.vc.easy

object L624 {
  def maxDistance(arr: List[List[Int]]): Int = {
    var max = Int.MinValue
    var min = Int.MaxValue
    var res = Int.MinValue
    var i = 0
    val n = arr.length
    while(i < n) {
      val minLocal = arr(i).head
      val maxLocal = arr(i).last

      if(i != 0) {
        res = Math.max(res, Math.abs(maxLocal - min))
        res = Math.max(res, Math.abs(minLocal - max))
      }

      max = Math.max(max, maxLocal)
      min = Math.min(min, minLocal)
      i += 1
    }
    res
  }
}
