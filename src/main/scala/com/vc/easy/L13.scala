package com.vc.easy

object L13 {
  def romanToInt(s: String): Int = {
    val map = Map(
      'I' -> 1,
      'V' -> 5,
      'X' -> 10,
      'L' -> 50,
      'C' -> 100,
      'D' -> 500,
      'M' -> 1000
    )
    var sum = 0
    val n = s.length
    if(n == 0) sum
    else {
      sum = map(s(n - 1))
      (n - 2 to 0 by -1).foreach(i => {
        val first = map(s(i))
        val second = map(s(i + 1))
        if(first >= second) sum += first
        else sum -= first
      })
      sum
    }
  }
}
