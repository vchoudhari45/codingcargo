package com.vc.easy

object L598 {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    if(ops.length == 0) return m * n
    var rowMin = Int.MaxValue
    var colMin = Int.MaxValue
    ops.foreach(x => {
      rowMin = Math.min(rowMin, x(0))
      colMin = Math.min(colMin, x(1))
    })
    rowMin * colMin
  }
}
