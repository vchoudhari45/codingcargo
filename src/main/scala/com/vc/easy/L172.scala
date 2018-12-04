package com.vc.easy

object L172 {
  def trailingZeroes(n: Int): Int = {
    //Zero is multiply of 5 * 2 so divide by 5 until number is zero
    var nVar = n
    var res = 0
    while(nVar != 0) {
      val r = nVar / 5
      res += r
      nVar = r
    }
    res
  }
}
