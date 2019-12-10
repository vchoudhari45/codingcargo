package com.vc.easy

object L599 {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String ,Int]()
    list1.indices.foreach(i => {
      map.put(list1(i), i)
    })
    var res = Int.MaxValue
    var out = new mutable.ArrayBuffer[String]()
    list2.indices.foreach(i => {
      if(map.contains(list2(i))) {
          val newRes = i + map(list2(i))
          if(res > newRes) {
            res = newRes
            out.clear
            out += list2(i)
          }
          else if(res == newRes) {
            out += list2(i)
          }
      }
    })
    out.toArray
  }
}
