package com.vc.easy

object L326 {
  def isPowerOfThree(n: Int): Boolean = {
    if(n == 0) return false
    var nVar = n
    while(nVar % 3 == 0) {
      nVar /= 3
    }
    nVar == 1
  }
}
