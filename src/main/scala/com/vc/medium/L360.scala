package com.vc.medium

object L360 {
  def sortTransformedArray(arr: Array[Int], a: Int, b: Int, c: Int): Array[Int] = {
    def solve(x: Int): Int = a * Math.pow(x, 2).toInt + b * x + c
    val n = arr.length
    val sorted = new Array[Int](n)
    var i = 0
    var j = n - 1
    var index = if(a >= 0) n - 1 else 0
    while(i <= j) {
      val iIndexValue = solve(arr(i))
      val jIndexValue = solve(arr(j))
      if(a >= 0) {
        if(iIndexValue >= jIndexValue) {
          sorted(index) = iIndexValue
          i += 1
        }
        else {
          sorted(index) = jIndexValue
          j -= 1
        }
        index -= 1
      }
      else {
        if(iIndexValue >= jIndexValue) {
          sorted(index) = jIndexValue
          i += 1
        }
        else {
          sorted(index) = iIndexValue
          j -= 1
        }
        index -= 1
      }
    }
    sorted
  }
}
