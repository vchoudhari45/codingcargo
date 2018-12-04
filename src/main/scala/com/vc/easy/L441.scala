package com.vc.easy

object L441 {
  def arrangeCoins(n: Int): Int = {
    var nVar = n
    var res = 1
    while(nVar > 0) {
      nVar -= res
      if(nVar >=0 ) res += 1
    }
    res - 1
  }
}
