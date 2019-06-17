package com.vc.medium

object L481 {
  def magicalString(n: Int): Int = {
    if(n == 0) return 0
    if(n <= 3) return 1

    val a = new Array[Int](n + 1)
    a(0) = 1
    a(1) = 2
    a(2) = 2
    var head = 2
    var tail = 3
    var res, num = 1
    while(tail < n) {
      (0 until a(head)).foreach(i => {
        a(tail) = num
        if(num == 1 && tail < n) res += 1
        tail += 1
      })
      head += 1
      num = num ^ 3
    }
    res
  }
}