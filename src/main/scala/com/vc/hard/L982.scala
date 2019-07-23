package com.vc.hard

object L982 {
  def countTriplets(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    var res = 0
    arr.indices.foreach(i => {
      arr.indices.foreach(j => {
        val num = arr(i) & arr(j)
        map.put(num, map.getOrElse(num, 0) + 1)
      })
    })

    arr.indices.foreach(i => {
      map.foreach(x => {
        if((arr(i) & x._1) == 0) {
          res += x._2
        }
      })
    })
    res
  }
}
