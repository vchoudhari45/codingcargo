package com.vc.easy

object L697 {
  def findShortestSubArray(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, (Int, Int, Int)]()
    arr.indices.foreach(i => {
      if(map.contains(arr(i))) {
        val e = map(arr(i))
        map.put(arr(i), (e._1 + 1, e._2, i))
      }
      else {
        map.put(arr(i), (1, i, i))
      }
    })

    var min = Int.MaxValue
    var max = Int.MinValue
    map.foreach(x => {
      if(x._2._1 > max) {
        max = x._2._1
        min = x._2._3 - x._2._2
      }
      else if(x._2._1 == max) {
        val m = x._2._3 - x._2._2
        if(m < min) min = m
      }
    })
    min + 1
  }
}
