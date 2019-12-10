package com.vc.medium

object L1014 {
  def maxScoreSightseeingPair(arr: Array[Int]): Int = {
    //[8, 1, 5, 2, 6]
    //res = 0
    //cur = 0

    //res = Math.max(res, arr(i) + cur)
    //cur = Math.max(cur, arr(i)) - 1

    //res = (0, 8) = 8
    //cur = (0, 8) - 1 = 7

    //res = (8, 1 + 7) = 8
    //cur = (7, 1) - 1 = 6

    //res = (8, 5 + 6) = 11
    //cur = (6, 5) - 1 = 5

    //res = (11, 2 + 5) = 11
    //cur = (5, 2) - 1 = 4

    //res = (11, 6 + 4) = 11
    //cur = (4, 6) - 1 = 5

    var i = 0
    val n = arr.length
    var currMax = 0
    var res = 0
    while(i < n) {
      res = Math.max(res, currMax + arr(i))
      currMax = Math.max(currMax, arr(i)) - 1
      i += 1
    }
    res
  }
}
