package com.vc.easy

object L643 {
  def findMaxAverage(arr: Array[Int], k: Int): Double = {
    var i = 0
    val n = arr.length
    var sum = 0.toDouble
    while(i < k) {
      sum += arr(i)
      i += 1
    }

    var maxAvg = sum / k
    while(i < n) {
      sum -= arr(i - k)
      sum += arr(i)
      maxAvg = Math.max(maxAvg, sum / k)
      i += 1
    }
    maxAvg
  }
}