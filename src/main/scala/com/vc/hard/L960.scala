package com.vc.hard

object L960 {
  def minDeletionSize(arr: Array[String]): Int = {
    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length
    val dp = Array.fill(m)(1)
    var res = m - 1

    def checkMaxIncSubSequenceCondForAllRows(i: Int, j: Int): Boolean = {
      var k = 0
      while(k < n) {
        if(arr(k)(i) < arr(k)(j)) return false
        k += 1
      }
      true
    }

    (1 until m).foreach(i => {
      (0 until i).foreach(j => {
        if(checkMaxIncSubSequenceCondForAllRows(i, j))
          dp(i) = Math.max(dp(i), dp(j) + 1)
      })
      res = Math.min(res, m - dp(i))
    })
    res
  }
}