package com.vc.easy

object L256 {
  def minCost(costs: Array[Array[Int]]): Int = {
    if(costs.length == 0) return 0
    val ans = costs.reduceRight((x, y) => {
      x(0) += Math.min(y(1), y(2))
      x(1) += Math.min(y(0), y(2))
      x(2) += Math.min(y(0), y(1))
      x
    })
    Math.min(Math.min(ans(0), ans(1)), ans(2))
  }
}