package com.vc.hard

object L354 {
  def maxEnvelopes(arr: Array[Array[Int]]): Int = {
    if(arr.length == 0) return 0
    //[[2,3], [5,4], [6,4], [6,7]]
    object EOrdering extends Ordering[Array[Int]] {
      def compare(x: Array[Int], y: Array[Int]): Int = {
        val cmp = x(0).compareTo(y(0))
        if(cmp != 0) return cmp
        else return x(1).compareTo(y(1))
      }
    }
    scala.util.Sorting.quickSort(arr)(EOrdering)
    val n = arr.length
    val dp = new Array[Int](n)
    var i = 0
    var j = 0
    while(i < n) {
      j = 0
      dp(i) = 1
      while(j < i) {
        if(canInsert(j, i)) {
          dp(i) = Math.max(dp(i), dp(j) + 1)
        }
        j += 1
      }
      i += 1
    }
    def canInsert(small: Int, big: Int): Boolean = {
      arr(small)(0) < arr(big)(0) && arr(small)(1) < arr(big)(1)
    }
    dp.max
  }
}
