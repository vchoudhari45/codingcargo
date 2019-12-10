package com.vc.easy

object L840 {
  def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
    val n = 3
    var res = 0
    (0 to grid.length - n).foreach(i => {
      (0 to grid(i).length - n).foreach(j => {
        if(isMagic(i, j)) res += 1
      })
    })

    def isMagic(x: Int, y: Int): Boolean = {
      import scala.collection.mutable
      val arr = new mutable.ArrayBuffer[Int]()
      val h = new Array[Int](n)
      val v = new Array[Int](n)
      var d1 = 0
      var d2 = 0
      (0 until n).foreach(i => {
        (0 until n).foreach(j => {
          val e = grid(i + x)(j + y)
          if(e < 1 || e > 9) return false
          if(arr.contains(e)) return false
          h(i) += e
          v(j) += e
          if(i == j) d1 += e
          if(i + j == n - 1) d2 += e
        })
      })

      val hDistinct = h.distinct
      val vDistinct = v.distinct
      hDistinct.length == 1 && vDistinct.length == 1 && hDistinct.head == vDistinct.head && hDistinct.head == d1 && d1 == d2
    }
    res
  }
}
