package com.vc.medium

object L539 {
  def findMinDifference(timePoints: List[String]): Int = {
    val n = 24 * 60
    val timeBoolean = new Array[Boolean](n)
    timePoints.foreach(x => {
      val arr = x.split(":")
      val time = arr(0).toInt * 60 + arr(1).toInt
      if(timeBoolean(time)) return 0
      timeBoolean(time) = true
    })
    var prev = 0
    var first = Int.MaxValue
    var last = Int.MinValue
    var min = Int.MaxValue
    timeBoolean.indices.foreach(i => {
      if(timeBoolean(i)) {
        if(first != Int.MaxValue) {
          min = Math.min(min, i - prev)
        }
        first = Math.min(first, i)
        last = Math.max(last, i)
        prev = i
      }
    })
    min = Math.min(min, 24 * 60 - last + first)
    min
  }
}
