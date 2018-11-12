package com.vc.easy

object L717 {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    var i = 0
    val n = bits.length
    while(i < n - 1){
      if(bits(i) == 0) i += 1
      else i += 2
    }
    i == n - 1
  }
}
