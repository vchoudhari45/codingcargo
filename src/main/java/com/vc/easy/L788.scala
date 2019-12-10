package com.vc.easy

object L788 {
  def rotatedDigits(N: Int): Int = {
    var res = 0
    (0 to N).foreach(i => {
      if(isValid(i)) res += 1
    })
    res
  }

  def isValid(N: Int): Boolean = {
    var n = N
    var isValidFound = false
    while(n != 0) {
      val digit = n % 10
      if(digit == 2 || digit == 5 || digit == 6 || digit == 9) isValidFound = true
      if(digit == 3 || digit == 4 || digit == 7) return false
      n = n / 10
    }
    isValidFound
  }
}
