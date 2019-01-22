package com.vc.medium

object L959 {
  def regionsBySlashes(grid: Array[String]): Int = {
    val n = grid.length
    val m = grid(0).length
    val nNew = n * 3
    val mNew = m * 3

    val g = Array.ofDim[Int](nNew, mNew)
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        if(grid(i)(j) == '/') {
          g(i * 3)(j * 3 + 2) = 1
          g(i * 3 + 1)(j * 3 + 1) = 1
          g(i * 3 + 2)(j * 3) = 1
        }
        else if(grid(i)(j) == '\\') {
          g(i * 3)(j * 3) = 1
          g(i * 3 + 1)(j * 3 + 1) = 1
          g(i * 3 + 2)(j * 3 + 2) = 1
        }
      })
    })

    val dirs = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    def dfs(x: Int, y: Int): Unit = {
      if(g(x)(y) == 0) {
        g(x)(y) = 1
        dirs.foreach(dir => {
          val xNew = x + dir._1
          val yNew = y + dir._2
          if(xNew >= 0 && xNew < nNew && yNew >= 0 && yNew < mNew) {
            dfs(xNew, yNew)
          }
        })
      }
    }

    var res = 0
    g.indices.foreach(i => {
      g(i).indices.foreach(j => {
        if(g(i)(j) == 0) {
          dfs(i, j)
          res += 1
        }
      })
    })
    res
  }
}
