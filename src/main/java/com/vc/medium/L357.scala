package com.vc.medium

object L357 {
  def countNumbersWithUniqueDigits(n: Int): Int = {
    if(n == 0) return 1
    if(n == 1) return 10
    var res = 10
    var uniqueDigits = 9
    var availableNumber = 9
    var nVar = n
    while(nVar > 1 && availableNumber > 0) {
      uniqueDigits = uniqueDigits * availableNumber
      res += uniqueDigits
      availableNumber -= 1
      nVar -= 1
    }
    res
  }
}
