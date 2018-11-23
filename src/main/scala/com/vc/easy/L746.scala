package com.vc.easy

object L746 {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    var i = 2
    val n = cost.length
    while(i < n) {
      cost(i) = cost(i) +  Math.min(cost(i - 1),  cost(i - 2))
      i += 1
    }
    Math.min(cost(n - 1), cost(n - 2))
  }
}
