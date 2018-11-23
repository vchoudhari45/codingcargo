package com.vc.easy

object L118 {
  def generate(numRows: Int): List[List[Int]] = {
    var i = 0
    var j = 0
    val res = new Array[List[Int]](numRows)
    while(i < numRows) {
      val arr = new Array[Int](i + 1)
      arr(0) = 1
      arr(i) = 1
      j = 1
      while(j < i) {
        arr(j) = res(i - 1)(j) + res(i - 1)(j - 1)
        j += 1
      }
      res(i) = arr.toList
      i += 1
    }
    res.toList
  }
}
