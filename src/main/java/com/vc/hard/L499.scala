package com.vc.hard

object L499 {
  def findShortestWay(arr: Array[Array[Int]], ball: Array[Int], hole: Array[Int]): String = {
    import scala.collection.mutable
    val n = arr.length
    val m = arr(0).length

    def move(x: Int, y: Int, xDir: Int, yDir: Int): (Int, Int, Int) = {
      var xNew = x
      var yNew = y
      var res = 0
      while(
        xNew + xDir >= 0 && xNew + xDir < n &&
          yNew + yDir >= 0 && yNew + yDir < m &&
          arr(xNew + xDir)(yNew + yDir) != 1 &&
          !(xNew + xDir == hole(0) && yNew + yDir == hole(1))
      ) {
        xNew = xNew + xDir
        yNew = yNew + yDir
        res += 1
      }
      if(xNew + xDir == hole(0) && yNew + yDir == hole(1)) (hole(0), hole(1), res + 1)
      else (xNew, yNew, res)
    }

    case class Point(x: Int, y: Int, distance: Int, str: String)
    object PQOrdering extends Ordering[Point] {
      def compare(p1: Point, p2: Point): Int = {
        if(p1.distance == p2.distance) p2.str.compareTo(p1.str)
        else p2.distance - p1.distance
      }
    }
    val dirs = Array(('d', 1, 0), ('l', 0, -1), ('r', 0, 1), ('u', -1, 0))
    val q = new mutable.PriorityQueue[Point]()(PQOrdering)
    val visited = new mutable.HashSet[(Int, Int)]()
    val p = Point(ball(0), ball(1), 0, "")
    q.enqueue(p)
    while(q.nonEmpty) {
      val point = q.dequeue()
      val x = point.x
      val y = point.y
      val res = point.str
      val dist = point.distance
      if(x == hole(0) && y == hole(1)) return res
      visited += ((x, y))
      dirs.foreach(dir => {
        val (xNew, yNew, distance) = move(x, y, dir._2, dir._3)
        val newPoint = Point(xNew, yNew, dist + distance, res + dir._1)
        if(!visited.contains(xNew, yNew)) q.enqueue(newPoint)
      })
    }
    "impossible"
  }
}