package com.vc

class L344 {
  def reverseString(str: String): String = {
    val sArr = str.toCharArray
    var s = 0
    var d = str.length - 1
    while(s < d) {
      val tmp = sArr(s)
      sArr(s) = sArr(d)
      sArr(d) = tmp
      s += 1
      d -= 1
    }
    sArr.mkString("")
  }
}
