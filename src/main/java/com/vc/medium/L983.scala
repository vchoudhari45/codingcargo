package com.vc.medium

object L983 {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val daysIncluded = new Array[Boolean](366)
    days.foreach(x => {
      daysIncluded(x) = true
    })

    val minCost = new Array[Int](366)
    (1 to 365).foreach(i => {
      if(daysIncluded(i)) {
        minCost(i) = minCost(i - 1) + costs(0)
        val minus7Days = Math.max(i - 7, 0)
        minCost(i) = Math.min(minCost(i), minCost(minus7Days) + costs(1))
        val minus30Days = Math.max(i - 30, 0)
        minCost(i) = Math.min(minCost(i), minCost(minus30Days) + costs(2))
      }
      else {
        minCost(i) = minCost(i - 1)
      }
    })
    minCost(365)
  }
}