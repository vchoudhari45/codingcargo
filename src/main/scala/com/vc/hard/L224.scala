package com.vc.hard

object L224 {
  def calculate(s: String): Int = {
    var prevRes = 0
    var prevSign = 1
    var res = 0
    var number = 0
    var sign = 1
    val n = s.length
    var i = 0
    while(i < n) {
      val ch = s(i)
      if(Character.isDigit(ch)) {
        number = 10 * number + (ch - '0')
      }
      else if(ch == '+') {
        res += sign * number
        number = 0
        sign = 1
      }
      else if(ch == '-') {
        res += sign * number
        number = 0
        sign = -1
      }
      else if(ch == '(') {
        prevRes = res
        prevSign = sign
        res = 0
        sign = 1
      }
      else if(ch == ')') {
        res += sign * number
        res *= prevSign
        res += prevRes
        prevRes = 0
        prevSign = 1
        number = 0
      }
      i += 1
    }
    if(number != 0) res += sign * number
    res
  }
}