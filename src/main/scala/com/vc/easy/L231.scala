package com.vc.easy

object L231 {
  def isPowerOfTwo(n: Int): Boolean = {
    if(n == 0) return false
    var nVar = n
    while(nVar % 2 == 0) {
      nVar = nVar / 2
    }
    nVar == 1
  }
}
