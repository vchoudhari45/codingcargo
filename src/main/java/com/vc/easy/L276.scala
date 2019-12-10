package com.vc.easy

object L276 {
  def numWays(n: Int, k: Int): Int = {
    if(n == 0) 0
    else if(n == 1) k
    else {
      var same = k
      var diff = k * (k - 1)
      (2 until n).foreach(x => {
        val total = diff + same
        same = diff
        diff = total * (k - 1)
      })
      same + diff
    }
  }
}
