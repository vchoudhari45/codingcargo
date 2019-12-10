package com.vc.easy

object L263 {
  def isUgly(num: Int): Boolean = {
    if(num == 0 ) return false
    var nVar = num
    val arr = Array(2, 3, 5)
    arr.foreach(x => {
      while(nVar % x == 0) nVar = nVar / x
    })
    nVar == 1
  }
}
