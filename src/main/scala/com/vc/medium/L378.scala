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
      val count = getLess(matrix, mid)
      if(count < k) lo = mid + 1
      else hi = mid - 1
    }
    lo
  }

  //Check diagonally from bottom-left to top-right
  def getLess(arr: Array[Array[Int]], mid: Int): Int = {
    val n = arr.length
    val m = arr(0).length
    var i = 0
    var j = m - 1
    var res = 0
    while(i < n) {
      while(j >= 0 && arr(i)(j) > mid) j -= 1
      res += (j + 1)
      i += 1
    }
    res
  }
}