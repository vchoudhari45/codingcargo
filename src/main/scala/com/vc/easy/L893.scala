package com.vc.easy

object L893 {
  def numSpecialEquivGroups(arr: Array[String]): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    arr.foreach(str => {
      val even = new mutable.StringBuilder()
      val odd = new mutable.StringBuilder()
      str.indices.foreach(i => {
        if(i % 2 == 0) even.append(str(i))
        else odd.append(str(i))
      })
      set += even.sorted.append(odd.sorted).toString
    })
    set.size
  }
}
