package com.vc.easy

object L532 {
  def findPairs(arr: Array[Int], k: Int): Int = {
    if(k < 0) return 0
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    arr.foreach(x => map.put(x, map.getOrElse(x, 0) + 1))

    if(k == 0) {
      map.count(x => x._2 >= 2)
    }
    else {
      var res = 0
      map.foreach(x => {
        if(map.contains(x._1 + k)) res += 1
      })
      res
    }
  }
}
