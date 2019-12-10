package com.vc.easy

object L892 {
  def surfaceArea(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        res += grid(i)(j) * 6
        if(grid(i)(j) > 1) {
          res -= (grid(i)(j) - 1) * 2                         //One cube will be top of other
        }
        if(i - 1 >= 0) {
          res -= Math.min(grid(i)(j), grid(i - 1)(j)) * 2    //Cubes which are side by side in a row
        }
        if(j - 1 >= 0) {
          res -= Math.min(grid(i)(j), grid(i)(j - 1)) * 2   //Cubes which are side by side in a col
        }
      })
    })
    res
  }
}
