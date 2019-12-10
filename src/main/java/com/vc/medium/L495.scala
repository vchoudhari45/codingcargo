package com.vc.medium

object L495 {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    var res = 0
    var newTime = 0
    var addDuration = 0
    timeSeries.foreach(time => {
      if(newTime > time) {
        addDuration = duration - (newTime - time)
        res += addDuration
      }
      else res += duration
      newTime = time + duration
    })
    res
  }
}