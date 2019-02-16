package com.vc.medium

object L647 {
  def countSubstrings(s: String): Int = {
    val n = s.length
    val arr = new Array[Char](2 * n + 3)
    arr(0) = '@'
    arr(1) = '#'
    arr(arr.length - 1) = '$'

    var i = 2
    s.foreach(x => {
      arr(i) = x
      arr(i + 1) = '#'
      i += 2
    })

    i = 1
    val p = new Array[Int](arr.length)
    var center = 0
    var right = 0
    while(i < arr.length - 1) {
      if(i < right) {
        p(i) = Math.min(right - i, p(2 * center - i))
      }
      while(arr(i + p(i) + 1) == arr(i - p(i) - 1)) {
        p(i) += 1
      }
      if(p(i) + i > right) {
        right = p(i) + i
        center = i
      }
      i += 1
    }
    var sum = 0
    p.foreach(x => sum += (x + 1) / 2)
    sum
  }
}
