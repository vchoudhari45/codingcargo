package com.vc.easy

object L504 {
  def convertToBase7(num: Int): String = {
    val cArr = Array('0','1','2','3','4','5','6')
    if(num == 0) return "0"
    var str = ""
    var numVar = if(num < 0) -1 * num else num
    while(numVar != 0){
      str = cArr(numVar % 7) + str
      numVar = numVar / 7
    }
    if(num < 0) "-" + str else str
  }
}