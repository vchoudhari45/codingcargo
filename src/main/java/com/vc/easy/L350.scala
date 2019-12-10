package com.vc.easy

object L350 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    val arr = new mutable.ArrayBuffer[Int]()
    nums1.foreach(x => {
      map.put(x, map.getOrElse(x, 0) + 1)
    })
    nums2.foreach(x => {
      if(map.contains(x) && map(x) > 0) {
        arr += x
        map.put(x, map(x) - 1)
      }
    })
    arr.toArray
  }
}
