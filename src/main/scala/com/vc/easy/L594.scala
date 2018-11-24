package com.vc.easy

object L594 {
  def findLHS(nums: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    nums.foreach(x => {
      map.put(x, map.getOrElse(x, 0) + 1)
    })

    var res = 0
    map.foreach(x => {
      if(map.contains(x._1 + 1)) {
        res = Math.max(res, x._2 + map(x._1 + 1))
      }
    })
    res
  }
}
