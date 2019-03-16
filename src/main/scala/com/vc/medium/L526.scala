package com.vc.medium

object L526 {
  def countArrangement(N: Int): Int = {
    var count = 0
    val arr = new Array[Int](N + 1)
    def solve(pos: Int): Unit = {
      if(pos > N) {
        count += 1
        return
      }
      (1 to N).foreach(i => {
        if(arr(i) == 0 && (pos % i == 0 || i % pos == 0)) {
          arr(i) = 1
          solve(pos + 1)
          arr(i) = 0
        }
      })
    }
    if(N == 0) return 0
    solve(1)
    count
  }
}
