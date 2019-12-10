package com.vc.easy

object L405 {
  def toHex(num: Int): String = {
    val cArr = Array('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f')
    if(num == 0) return "0"
    var str = ""
    var numVar = num
    while(numVar != 0){
      str = cArr(numVar & 15) + str
      numVar = numVar >>> 4
    }
    str
  }
}
