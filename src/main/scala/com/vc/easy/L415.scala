package com.vc.easy

object L415 {
  def addStrings(num1: String, num2: String): String = {
    import scala.collection.mutable
    var i = num1.length - 1
    var j = num2.length - 1
    var carry = 0
    val str = new mutable.StringBuilder()
    while(i >= 0 && j >= 0) {
      val digit1 = num1(i) - '0'
      val digit2 = num2(j) - '0'
      val digit = digit1 + digit2 + carry
      str.append(digit % 10)
      carry = digit / 10
      i -= 1
      j -= 1
    }

    while(i >= 0) {
      val digit = num1(i) - '0' + carry
      str.append(digit % 10)
      carry = digit / 10
      i -= 1
    }

    while(j >= 0) {
      val digit = num2(j) - '0' + carry
      str.append(digit % 10)
      carry = digit / 10
      j -= 1
    }

    if(carry != 0) str.append(carry)
    str.reverse.toString
  }
}
