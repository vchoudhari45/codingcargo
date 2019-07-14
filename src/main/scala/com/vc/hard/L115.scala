package com.vc.hard

object L115 {
  def numDistinct(s: String, t: String): Int = {
    val n = s.length
    val m = t.length
    /**
              0  r  a  b  b  i  t
            0 1, 0, 0, 0, 0, 0, 0
            r 1, 1, 0, 0, 0, 0, 0
            a 1, 1, 1, 0, 0, 0, 0
            b 1, 1, 1, 1, 0, 0, 0
            b 1, 1, 1, 2, 1, 0, 0
            b 1, 1, 1, 3, 3, 0, 0
            i 1, 1, 1, 3, 3, 3, 0
            t 1, 1, 1, 3, 3, 3, 3
      */
    if(n < m) return 0
    val dp = Array.ofDim[Int](n + 1, m + 1)
    dp.indices.foreach(i => {
      dp(i).indices.foreach(j => {
        if(j == 0) {
          dp(i)(j) = 1
        }
        else if(i == 0) {
          dp(i)(j) = 0
        }
        else {
          if(s(i - 1) == t(j - 1)) {
            dp(i)(j) = dp(i - 1)(j) + dp(i - 1)(j - 1)
          }
          else {
            dp(i)(j) = dp(i - 1)(j)
          }
        }
      })
    })
    //dp.indices.foreach(i => println(dp(i).mkString(", ")))
    dp(n)(m)
  }
}
