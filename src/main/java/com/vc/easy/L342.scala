package com.vc.easy

object L342 {
  def isPowerOfFour(num: Int): Boolean = {
    if(num == 0) return false
    var nVar = num
    while(nVar % 4 == 0) nVar = nVar / 4
    nVar == 1
  }
}
