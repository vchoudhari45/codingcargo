package com.vc.hard

object L660 {
  def newInteger(n: Int): Int = {
    //Integer.parseInt(Integer.toString(n, 9))

    var ans = 0
    var base = 1
    var nVar = n
    while(nVar > 0) {
      ans += nVar % 9 * base
      nVar = nVar / 9
      base = base * 10
    }
    ans
  }
}
