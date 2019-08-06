package com.vc.hard

object L302 {
  def minArea(arr: Array[Array[Char]], x: Int, y: Int): Int = {
    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length

    def searchCol(from: Int, to: Int, leftSide: Boolean) : Int = {
      var lo = from
      var hi = to
      while(lo < hi) {
        var iterateRow = 0
        val mid = lo + (hi - lo) / 2
        while(iterateRow < n && arr(iterateRow)(mid) == '0') iterateRow += 1

        //Found 1 while iterating over Row
        //Look further left if there is any black pixel, if we are searching in leftHalf
        if((iterateRow < n) == leftSide) hi = mid
        //Else look on the rightSide, if we are searching in leftHalf
        else lo = mid + 1
      }
      lo
    }
    val left = searchCol(0, y, true)
    val right = searchCol(y + 1, m, false)

    def searchRow(from: Int, to: Int, topSide: Boolean): Int = {
      var lo = from
      var hi = to
      while(lo < hi) {
        var iterateCol = left
        val mid = lo + (hi - lo) / 2
        while(iterateCol < right && arr(mid)(iterateCol) == '0') iterateCol += 1

        //Found 1 while iterating over col
        //Look further top if there is any black pixel, if we are searching in topHalf
        if((iterateCol < right) == topSide) hi = mid
        //else look further on the bottom, if we are searching in topHalf
        else lo = mid + 1
      }
      lo
    }
    val top = searchRow(0, x, true)
    val bottom = searchRow(x + 1, n, false)

    return (right - left) * (bottom - top)
  }
}