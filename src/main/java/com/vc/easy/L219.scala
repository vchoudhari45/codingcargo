package com.vc.easy

object L219 {
  def containsNearbyDuplicate(arr: Array[Int], k: Int): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    arr.indices.foreach(i => {
      if(map.contains(arr(i)) && i - map(arr(i)) <= k) return true
      map.put(arr(i), i)
    })
    false
  }
}
