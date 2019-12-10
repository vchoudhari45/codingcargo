package com.vc.easy

object L66 {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val n = digits.length
    var i = n - 1
    var carry = 0
    while(i >= 0) {
      val sum = if(i == n - 1) digits(i) + 1 else digits(i) + carry
      if(sum > 9) {
        carry = sum / 10
        digits(i) = sum % 10
      }
      else {
        carry = 0
        digits(i) = sum
      }
      i -= 1
    }
    if(carry > 0) {
      val newArr = new Array[Int](digits.length + 1)
      newArr(0) = carry
      digits.indices.foreach(i => newArr(i + 1) = digits(i))
      newArr
    }
    else digits
  }
}