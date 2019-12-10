package com.vc.medium

object L338 {
  def countBits(num: Int): Array[Int] = {
    val arr = new Array[Int](num + 1)
    (1 to num).foreach(i => {
      arr(i) = arr(i >> 1) + (i & 1) //i >> 1 means divide by two and (i & 1) means add 1 to answer if number is even
    })
    arr
  }
}