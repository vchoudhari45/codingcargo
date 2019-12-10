package com.vc.medium

object L378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val n = matrix.length
    if(n == 0) return 0
    val m = matrix(0).length

    var lo = matrix(0)(0)
    var hi = matrix(n - 1)(m - 1)

    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      var row = 0
      var col = m - 1
      var count = 0
      while(row < n && col >= 0) {
        //Take full row in the answer
        if(matrix(row)(col) <= mid) {
          count += col + 1
          row += 1
        }
        //Decrement column 1 by 1 to reach either mid or less than mid value
        else col -= 1
      }
      if(count < k) lo = mid + 1
      else hi = mid - 1
    }
    lo
  }
}