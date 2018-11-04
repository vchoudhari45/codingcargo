package com.vc.easy

object L476 {
  /**
    * This works because addition of number and it's complement is equal to all ones
    */
  def findComplement(num: Int): Int = {
    var i = 0
    var j = 0
    while(i < num) {
      i += Math.pow(2, j).toInt
      j += 1
    }
    i - num
  }
}
