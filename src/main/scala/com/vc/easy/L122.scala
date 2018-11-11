package com.vc.easy

object L122 {
  def maxProfit(prices: Array[Int]): Int = {
    var sum = 0
    (0 until prices.length - 1).foreach(i => {
      if(prices(i + 1) > prices(i)) sum += prices(i + 1) - prices(i)
    })
    sum
  }
}
