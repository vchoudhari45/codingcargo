package com.vc.easy

object L507 {
  def checkPerfectNumber(num: Int): Boolean = {
    if(num == 0 || num == 1) return false

    val n = Math.sqrt(num).toInt
    var res = 1
    (2 to n).foreach(i => {
      if(num % i == 0) res += num / i + i
    })
    res == num
  }
}
