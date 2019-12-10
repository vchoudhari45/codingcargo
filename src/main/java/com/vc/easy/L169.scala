package com.vc.easy

object L169 {
  def majorityElement(num: Array[Int]): Int = {
    var i = 1
    var res = num(0)
    var count = 1
    val n = num.length
    while(i < n) {
      if(count == 0) {
        res = num(i)
        count = 1
      }
      else if(res == num(i)) count += 1
      else count -= 1
      i += 1
    }
    res
  }
}