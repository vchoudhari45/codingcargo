package com.vc.medium

object L462 {
  def minMoves2(arr: Array[Int]): Int = {
    scala.util.Sorting.quickSort(arr)
    var i = 0
    var j = arr.length - 1
    var count = 0
    while(i < j) {
      count += arr(j) - arr(i)
      i += 1
      j -= 1
    }
    count
  }
}
