package com.vc.easy

object L7 {
  def reverse(x: Int): Int = {
    var xVar = x
    var xRes = 0l
    while(xVar != 0){
      val digit = xVar % 10
      xVar = xVar / 10
      xRes = xRes * 10 + digit
    }
    if(xRes > Int.MaxValue || xRes < Int.MinValue) 0 else xRes.toInt
  }
}
