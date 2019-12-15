package com.vc.medium

object L289 {
  def gameOfLife(arr: Array[Array[Int]]): Unit = {
    val dirs = Array((0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1))

    val n = arr.length
    if(n == 0) return
    val m = arr(0).length

    def solve(x: Int, y: Int): Unit = {
      var live = 0
      dirs.foreach(dir => {
        val xNew = dir._1 + x
        val yNew = dir._2 + y
        if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && (arr(xNew)(yNew) & 1) == 1) live += 1
      })
      if((arr(x)(y) & 1) == 1 && live >= 2  && live <= 3) {
        arr(x)(y) = 3
      }
      if((arr(x)(y) & 1) == 0 && live == 3) {
        arr(x)(y) = 2
      }
    }
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        solve(i, j)
      })
    })
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        arr(i)(j) = arr(i)(j) >> 1
      })
    })
  }
}
