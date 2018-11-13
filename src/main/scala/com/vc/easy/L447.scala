package com.vc.easy

object L447 {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    val n = points.length
    var res = 0
    (0 until n).foreach(i => {
      (0 until n).foreach(j => {
        if(i != j) {
          val distance = getDistance(points(i), points(j))
          map.put(distance, map.getOrElse(distance, 0) + 1)
        }
      })
      map.foreach(x => {
        res += x._2 * (x._2 - 1)
      })
      map.clear
    })
    res
  }

  def getDistance(x:Array[Int], y: Array[Int]): Int = {
    val dx = x(0) - y(0)
    val dy = x(1) -  y(1)
    (Math.pow(dx, 2) + Math.pow(dy, 2)).toInt
  }
}
