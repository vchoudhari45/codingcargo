package com.vc.medium

object L454 {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    var count = 0
    A.indices.foreach(i => {
      B.indices.foreach(j => {
        val sum = A(i) + B(j)
        map.put(sum, map.getOrElse(sum, 0) + 1)
      })
    })

    C.indices.foreach(i => {
      D.indices.foreach(j => {
        val sum = -1 * (C(i) + D(j))
        if(map.contains(sum)) {
          count += map(sum)
        }
      })
    })
    count
  }
}
