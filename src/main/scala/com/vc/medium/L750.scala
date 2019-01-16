package com.vc.medium

object L750 {
  def countCornerRectangles(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val m = grid(0).length

    var res = 0
    (0 until n).foreach(i => {
      (0 until m).foreach(j => { //top-right point
        if(grid(i)(j) == 1) {
          (i + 1 until n).foreach(k => {
            if(grid(k)(j) == 1) {  //bottom-right point
              (j + 1 until m).foreach(l => {
                if(grid(i)(l) == 1 && grid(k)(l) == 1) { //bottom-left & top-left
                  res += 1
                }
              })
            }
          })
        }
      })
    })
    res
  }
}
