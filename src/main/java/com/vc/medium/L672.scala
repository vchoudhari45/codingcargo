package com.vc.medium

object L672 {

  // 1 + 2 -> 3, 1 + 3 -> 2, 2 + 3 -> 1
  //all_on, 1, 2, 3, 4, 1 + 4, 2 + 4, 3 + 4 for m >= 2 & n > 1
  // m > 2 && n > 2

  def flipLights(n: Int, m: Int): Int = {
    if(n == 0 || m == 0) return 1
    if(n == 1) return 2
    if(n == 2 && m == 1) return 3
    if(n == 2 || m == 1) return 4
    if(m == 2) return 7
    8
  }
}
