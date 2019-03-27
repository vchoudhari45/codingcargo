package com.vc.medium

object L547 {
  def findCircleNum(arr: Array[Array[Int]]): Int = {
    val n = arr.length
    val visited = new Array[Boolean](n)
    var count = 0
    def solve(i: Int): Unit = {
      (0 until n).foreach(j => {
        if(arr(i)(j) == 1 && !visited(j)) {
          visited(j) = true
          solve(j)
        }
      })
    }
    (0 until n).foreach(i => {
      if(!visited(i)) {
        visited(i) = true
        count += 1
        solve(i)
      }
    })
    count
  }
}
