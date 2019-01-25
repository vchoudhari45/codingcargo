package com.vc.medium

object L442 {
  def findDuplicates(arr: Array[Int]): List[Int] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    arr.indices.foreach(i => {
      val idx = Math.abs(arr(i)) - 1
      if(arr(idx) < 0) list += idx + 1
      else arr(idx) = -1 * arr(idx)
    })
    list.toList
  }
}
