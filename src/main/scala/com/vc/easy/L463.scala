package com.vc.easy

object L463 {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    val dirs = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    var perimeter = 0
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        if(grid(i)(j) == 1) {
          dirs.foreach(dir => {
            val x = i + dir._1
            val y = j + dir._2
            if(x >= 0 && x < grid.length && y >= 0 && y < grid(i).length) {
              if(grid(x)(y) == 0) perimeter += 1
            }
            else {
              perimeter += 1
            }
          })
        }
      })
    })
    perimeter
  }
}
