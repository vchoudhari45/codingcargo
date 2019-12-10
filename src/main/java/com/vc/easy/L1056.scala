package com.vc.easy

object L1056 {
  def confusingNumber(n: Int): Boolean = {
    var nVar = n
    var nNew = 0
    while(nVar != 0) {
      val digit = nVar % 10
      nVar = nVar / 10
      if(digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 7) return false
      else if(digit == 6) nNew = nNew * 10 + 9
      else if(digit == 9) nNew = nNew * 10 + 6
      else nNew = nNew * 10 + digit
    }
    n != nNew
  }
}
