package com.vc.medium

object L64 {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val m = grid(0).length

    (0 until m - 1).foreach(j => {
      grid(0)(j + 1) += grid(0)(j)
    })

    (0 until n - 1).foreach(i => {
      grid(i + 1)(0) += grid(i)(0)
    })

    (1 until n).foreach(i => {
      (1 until m).foreach(j => {
        grid(i)(j) = Math.min(grid(i)(j) + grid(i - 1)(j), grid(i)(j) + grid(i)(j - 1))
      })
    })
    grid(n - 1)(m  - 1)
  }
}