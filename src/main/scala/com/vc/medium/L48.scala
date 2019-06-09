package com.vc.medium

object L48 {
  def rotate(arr: Array[Array[Int]]): Unit = {
    // 1 2 3
    // 4 5 6
    // 7 8 9

    //First get 7 where it should be, if it was anti-clock wise then vertical swap
    // 7 8 9
    // 4 5 6
    // 1 2 3
    var s = 0
    var e = arr.length - 1
    while(s < e) {
      arr(s).indices.foreach(i => {
        val tmp = arr(s)(i)
        arr(s)(i) = arr(e)(i)
        arr(e)(i) = tmp
      })
      s += 1
      e -= 1
    }

    //And then do the transpose arr(i)(j) = arr(j)(i)
    // 7 4 1
    // 8 5 2
    // 9 6 3
    arr.indices.foreach(i => {
      (i + 1 until arr.length).foreach(j => {
        val tmp = arr(i)(j)
        arr(i)(j) = arr(j)(i)
        arr(j)(i) = tmp
      })
    })
  }
}
