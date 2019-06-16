package com.vc.medium

object L59 {
  /**
    * Input: 3
    * Output:
    * [
    *  [ 1, 2, 3 ],
    *  [ 8, 9, 4 ],
    *  [ 7, 6, 5 ]
    * ]
    **/
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val arr = Array.ofDim[Int](n, n)

    if(n == 0) return arr
    var num = 1
    var rowStart = 0
    var rowEnd = n - 1
    var colStart = 0
    var colEnd = n - 1
    while(rowStart <= rowEnd && colStart <= colEnd) {
      var i = colStart
      while(i <= colEnd) {
        arr(rowStart)(i) = num
        num += 1
        i += 1
      }
      rowStart += 1

      i = rowStart
      while(i <= rowEnd) {
        arr(i)(colEnd) = num
        i += 1
        num += 1
      }
      colEnd -= 1

      i = colEnd
      while(i >= colStart) {
        arr(rowEnd)(i) = num
        i -= 1
        num += 1
      }
      rowEnd -= 1

      i = rowEnd
      while(i >= rowStart) {
        arr(i)(colStart) = num
        i -= 1
        num += 1
      }
      colStart += 1
    }
    arr
  }
}
