package com.vc.hard

object L668 {
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    var lo = 0
    var hi = m * n

    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2

      var row = 1
      var col = n
      var count = 0
      while(row <= m && col > 0) {
        //Take full row
        if(row * col <= mid) {
          count += col
          row += 1
        }
        //decrement col until you find number less than or equal to mid
        else col -= 1
      }

      if(count < k) lo = mid + 1
      else hi = mid - 1
    }
    lo
  }
}