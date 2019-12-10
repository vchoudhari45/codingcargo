package com.vc.hard

object L265 {
  def minCostII(cost: Array[Array[Int]]): Int = {
    val n = cost.length
    if(n == 0) return 0
    val m = cost(0).length
    var i = 0
    var j = 0
    var minIndex1 = -1
    var minIndex2 = -1
    var minFirst = Int.MaxValue
    var minSecond = Int.MaxValue
    while(i < n) {
      j = 0
      while(j < m) {
        if(j != minIndex1) cost(i)(j) += (if(minIndex1 != -1) cost(i - 1)(minIndex1) else 0)
        else cost(i)(j) += (if(minIndex2 != -1) cost(i - 1)(minIndex2) else 0)
        j += 1
      }
      j = 0
      minFirst = Int.MaxValue
      minSecond = Int.MaxValue
      minIndex1 = -1
      minIndex2 = -1
      while(j < m) {
        if(cost(i)(j) <= minFirst) {
          minSecond = minFirst
          minIndex2 = minIndex1
          minFirst = cost(i)(j)
          minIndex1 = j
        }
        else if(cost(i)(j) <= minSecond && minIndex1 != j) {
          minSecond = cost(i)(j)
          minIndex2 = j
        }
        j += 1
      }
      i += 1
    }
    i = n - 1
    j = 0
    var res = Int.MaxValue
    while(j < m) {
      res = Math.min(res, cost(i)(j))
      j += 1
    }
    res
  }
}
