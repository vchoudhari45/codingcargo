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
    var i = n - 1
    var j = 0
    var res = 0
    while(i >= 0 && j < m) {
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