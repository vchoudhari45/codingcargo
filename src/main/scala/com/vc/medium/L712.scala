package com.vc.medium

object L712 {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    /**
         0    e    a    t
      0 000, 101, 198, 314
      s 115, 216, 313, 429
      e 216, 115, 212, 328
      a 313, 212, 115, 231
    */
    val n = s1.length
    val m = s2.length
    val arr = Array.ofDim[Int](n + 1, m + 1)
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(i == 0 && j == 0) {
          arr(i)(j) = 0
        }
        else if(i == 0) {
          arr(i)(j) = arr(i)(j - 1) + s2(j - 1).toInt
        }
        else if(j == 0) {
          arr(i)(j) = arr(i - 1)(j) + s1(i - 1).toInt
        }
        else {
          var prev = arr(i - 1)(j - 1)
          if(s1(i - 1) != s2(j - 1)) {
            prev += s1(i - 1).toInt + s2(j - 1).toInt
          }
          arr(i)(j) = Math.min(prev, Math.min(arr(i - 1)(j) + s1(i - 1).toInt, arr(i)(j - 1) + s2(j - 1).toInt))
        }
      })
    })
    arr(n)(m)
  }
}