package com.vc.easy

object L121 {
  def maxProfit(prices: Array[Int]): Int = {
    var res = 0
    prices.foldLeft(Int.MaxValue)((minPrice:Int, price:Int) => {
      if(minPrice > price) price
      else {
        res = Math.max(res, price - minPrice)
        minPrice
      }
    })
    res
  }
}