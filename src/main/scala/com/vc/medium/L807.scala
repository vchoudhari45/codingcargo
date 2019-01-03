package com.vc.medium

object L807 {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val row = new Array[Int](n)
    val col = new Array[Int](n)

    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        row(i) = Math.max(row(i), grid(i)(j))
        col(j) = Math.max(col(j), grid(i)(j))
      })
    })

    var sum = 0
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        sum += Math.min(row(i), col(j)) - grid(i)(j)
      })
    })
    sum
  }
}
