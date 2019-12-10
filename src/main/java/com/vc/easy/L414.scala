package com.vc.easy

object L414 {
  def thirdMax(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val top3 = new mutable.TreeSet[Int]()
    arr.foreach(x => {
      top3 += x
      if(top3.size > 3) top3.remove(top3.head)
    })
    if(top3.size < 3) top3.max else top3.min
  }
}
