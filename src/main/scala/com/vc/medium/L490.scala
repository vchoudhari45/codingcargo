package com.vc.medium

object L490 {
  def hasPath(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Boolean = {
    val dirs = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    val sPoint = (start(0), start(1))
    val dPoint = (destination(0), destination(1))

    import scala.collection.mutable
    val visited = new mutable.HashSet[(Int, Int)]()

    val n = maze.length
    val m = maze(0).length
    def canRoll(point: (Int, Int), dir:(Int, Int)) : (Int, Int) = {
      var newX = point._1
      var newY = point._2
      while(newX + dir._1 < n
        && newX + dir._1 >= 0
        && newY + dir._2 < m
        && newY + dir._2 >= 0
        && maze(newX + dir._1)(newY + dir._2) != 1) {
        newX += dir._1
        newY += dir._2
      }
      (newX, newY)
    }

    val q = new mutable.Stack[(Int, Int)]()
    q.push(sPoint)
    visited += sPoint
    while(q.nonEmpty) {
      val point = q.pop()
      dirs.foreach(dir => {
        val newPoint = canRoll(point, dir)
        if(newPoint != point && !visited.contains(newPoint)) {
          visited += newPoint
          q.push(newPoint)
          println(q.mkString(", "))
          if(newPoint == dPoint) return true
        }
      })
    }
    false
  }
}
