package com.vc.medium

object L947 {
  def removeStones(stones: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val visited = new mutable.HashSet[(Int, Int)]()
    var noOfIsland = 0

    stones.foreach(point => {
      val x = point(0)
      val y = point(1)
      if(!visited.contains((x, y))) {
        dfs(x, y)
        noOfIsland += 1
      }
    })

    def dfs(x: Int, y: Int): Unit = {
      visited += ((x, y))
      stones.foreach(point => {
        val x1 = point(0)
        val y1 = point(1)
        if(x1 == x || y1 == y) {
          if(!visited.contains(x1, y1)) dfs(x1, y1)
        }
      })
    }
    stones.length - noOfIsland
  }
}