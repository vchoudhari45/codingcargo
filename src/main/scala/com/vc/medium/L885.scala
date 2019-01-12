package com.vc.medium

object L885 {
  def spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    var r = r0
    var c = c0

    var len = 0
    val dir = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    var dirIndex = 0

    val count = R * C
    val res = new Array[Array[Int]](count)
    res(0) = Array(r, c)

    var i = 1
    while(i < count) {
      if(dirIndex == 0 || dirIndex == 2) len += 1
      (0 until len).foreach(_ => {
        r = r + dir(dirIndex)._1
        c = c + dir(dirIndex)._2
        if(r >= 0 && r < R && c >= 0 && c < C) {
          res(i) = Array(r, c)
          i += 1
        }
      })
      dirIndex = (dirIndex + 1) % 4
    }
    res
  }
}
