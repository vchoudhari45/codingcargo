package com.vc.medium

object L477 {
  def totalHammingDistance(arr: Array[Int]): Int = {
    var res = 0
    val n = arr.length
    (0 until 32).foreach(i => {
      var bitCount = 0
      arr.foreach(x => {
        bitCount += (x >> i) & 1
      })
      res += bitCount * (n - bitCount)
    })
    res
  }
}
