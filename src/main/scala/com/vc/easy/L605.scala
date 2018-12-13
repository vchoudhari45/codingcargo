package com.vc.easy

object L605 {
  def canPlaceFlowers(arr: Array[Int], n: Int): Boolean = {
    val l = arr.length
    var res = n
    var i = 0
    while(i < l && res > 0) {
      if(arr(i) == 0) {
        val prevEmpty = if(i == 0) true else arr(i - 1) == 0
        val nextEmpty = if(i == l - 1) true else arr(i + 1) == 0
        if(prevEmpty && nextEmpty) {
          res -= 1
          arr(i) = 1
        }
      }
      i += 1
    }
    res == 0
  }
}
