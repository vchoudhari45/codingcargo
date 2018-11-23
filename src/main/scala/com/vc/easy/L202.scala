package com.vc.easy

object L202 {
  def isHappy(n: Int): Boolean = {
    var hare = n
    var tortoise = n
    do {
      tortoise = solve(tortoise)
      hare = solve(hare)
      hare = solve(hare)
    }while(hare != tortoise)
    tortoise == 1
  }

  def solve(n: Int): Int = {
    var nVar = n
    var res = 0
    while(nVar != 0) {
      val digit = nVar % 10
      res += Math.pow(digit, 2).toInt
      nVar = nVar / 10
    }
    res
  }
}
