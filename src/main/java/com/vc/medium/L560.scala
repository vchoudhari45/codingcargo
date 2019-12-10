package com.vc.medium

object L560 {
  def subarraySum(arr: Array[Int], k: Int): Int = {
    var res = 0
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    map.put(0, 1)
    var sum = 0
    arr.indices.foreach(i => {
      sum += arr(i)
      if(map.contains(sum - k)) {
        res += map(sum - k)
      }
      map.put(sum, map.getOrElse(sum, 0) + 1)
    })
    res
  }
}
