package com.vc.medium

object L939 {
  def minAreaRect(points: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.HashSet[Int]]()
    var min = Int.MaxValue
    points.foreach(point => {
      val x = point(0)
      val y = point(1)
      val set = map.getOrElse(x, new mutable.HashSet[Int]())
      set += y
      map.put(x, set)
    })
    points.foreach(p1 => {
      points.foreach(p2 => {
        if(p1(0) != p2(0) && p1(1) != p2(1)) {
          if(map(p1(0)).contains(p2(1)) && map(p2(0)).contains(p1(1))) {
            min = Math.min(min, Math.abs(p1(0) - p2(0)) * Math.abs(p1(1) - p2(1)))
          }
        }
      })
    })
    if(min == Int.MaxValue) 0 else min
  }
}
