package com.vc.medium

object L554 {
  def leastBricks(wall: List[List[Int]]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    wall.foreach(bricks => {
      var len = 0
      (0 until bricks.length - 1).foreach(i => {
        len += bricks(i)
        map.put(len, map.getOrElse(len, 0) + 1)
      })
    })
    val count = if(map.nonEmpty) map.maxBy(_._2)._2 else 0
    wall.length - count
  }
}
