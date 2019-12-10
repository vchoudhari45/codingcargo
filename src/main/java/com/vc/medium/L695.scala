package com.vc.medium

object L695 {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    /**
      * [
      *   [1,1,0,0,0],
      *   [1,1,0,0,0],
      *   [0,0,0,1,1],
      *   [0,0,0,1,1]
      * ]
      */

    val dirs = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    val n = grid.length
    val m = grid(0).length

    var maxRes = 0
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        if(grid(i)(j) == 1) {
          maxRes = Math.max(maxRes, solve(i, j))
        }
      })
    })

    def solve(x: Int, y: Int): Int = {
      var res = 1
      grid(x)(y) = 0
      dirs.foreach(dir => {
        val xNew = x + dir._1
        val yNew = y + dir._2
        if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && grid(xNew)(yNew) == 1) {
          res += solve(xNew, yNew)
        }
      })
      res
    }
    maxRes
  }
}