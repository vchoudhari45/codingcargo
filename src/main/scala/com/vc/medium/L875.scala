package com.vc.medium

object L875 {
  def minEatingSpeed(piles: Array[Int], H: Int): Int = {
    val n = piles.length
    def canEat(eat: Int): Boolean = {
      var countHours = 0
      piles.foreach(pile => {
        countHours += pile / eat
        if(pile % eat != 0) countHours += 1
      })
      countHours <= H
    }
    var end = piles.max
    var start = 1
    while(start <= end) {
      val mid = start + (end - start) / 2
      if(canEat(mid)) end = mid - 1
      else start = mid + 1
    }
    start
  }
}