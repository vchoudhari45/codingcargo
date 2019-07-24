package com.vc.hard

object L128 {
  def longestConsecutive(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    var res = 0
    arr.indices.foreach(i => {
      if(!map.contains(arr(i))) {
        val left = map.getOrElse(arr(i) - 1, 0)
        val right = map.getOrElse(arr(i) + 1, 0)

        val total = left + 1 + right
        res = Math.max(res, total)
        map.put(arr(i), total)
        map.put(arr(i) - left, total)
        map.put(arr(i) + right, total)
      }
    })
    res
  }
}
