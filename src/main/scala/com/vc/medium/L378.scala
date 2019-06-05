package com.vc.medium

object L378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val n = matrix.length
    var lo = matrix(0)(0)
    var hi = matrix(n - 1)(n - 1)
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      val count = getLess(matrix, mid)
      if(count < k) lo = mid + 1
      else hi = mid - 1
    }
    lo
  }

  def getLess(arr: Array[Array[Int]], mid: Int): Int = {
    val n = arr.length
    var i = n - 1
    var j = 0
    var res = 0
    while(i >= 0 && j < n) {
      if(arr(i)(j) > mid) {
        i -= 1
      }
      else {
        res += i + 1
        j += 1
      }
    }
    res
  }
}
