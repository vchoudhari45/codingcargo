package com.vc.easy

import scala.annotation.tailrec

object L728 {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[Int]()
    (left to right).foreach(i => {
      if(isSelfDividingNumber(i, i)) res += i
    })
    res.toList
  }

  @tailrec def isSelfDividingNumber(original: Int, number: Int): Boolean = {
    if(original < 10) return true
    val digit = number % 10
    if(digit == 0) return false
    if(digit != 1 && original % digit != 0) return false
    if(number < 10) return true
    isSelfDividingNumber(original, number / 10)
  }
}
