package com.vc.medium

object L238 {
  def productExceptSelf(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    val res = new Array[Int](n)
    res(0) = 1
    (1 until n).foreach(i => {
      res(i) = arr(i - 1) * res(i - 1)
    })

    var runningProduct = 1
    (n - 1 to 0 by -1).foreach(i => {
      res(i) *= runningProduct
      runningProduct *= arr(i)
    })
    res
  }
}
