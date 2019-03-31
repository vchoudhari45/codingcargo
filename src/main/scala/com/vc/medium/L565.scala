package com.vc.medium

object L565 {
  def arrayNesting(arr: Array[Int]): Int = {
    var i = 0
    var j = 0
    var max = 0
    var size = 0
    val n = arr.length
    while(i < n) {
      size = 0
      j = i
      while(arr(j) >= 0) {
        size += 1
        val aj = arr(j)
        arr(j) = -1
        j = aj
      }
      max = Math.max(max, size)
      i += 1
    }
    max
  }
}
