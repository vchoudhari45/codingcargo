package com.vc.medium

//[1, 5, 233, 7]
object L486 {
  def PredictTheWinner(arr: Array[Int]): Boolean = {
    val n = arr.length
    val dp = Array.ofDim[Int](n, n)
    /**

             0  1  2    3
          0  1, 4, 229, 222
          1  0, 5, 228,-221
          2  0, 0, 233, 226
          3  0, 0, 000, 007
      **/
    var i = 0
    var j = 0
    var k = 0
    while(i < n) {
      j = 0
      k = i
      while(k < n) {
        if(j == k) dp(j)(k) = arr(j)
        else {
          val selectStart = arr(j) - dp(j + 1)(k)
          val selectEnd = arr(k) - dp(j)(k - 1)
          dp(j)(k) = Math.max(selectStart, selectEnd)
        }
        j += 1
        k += 1
      }
      i += 1
    }
    dp(0)(n - 1) >= 0
  }
}
