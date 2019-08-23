package com.vc.medium

object L373 {
  def kSmallestPairs(arr1: Array[Int], arr2: Array[Int], k: Int): List[List[Int]] = {
    val n = arr1.length
    val m = arr2.length

    import scala.collection.mutable
    val list = new mutable.ListBuffer[List[Int]]()

    if(n == 0 || m == 0) return list.toList
    object PQOrdering extends Ordering[(Int, Int, Int)] {
      def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3.compareTo(x._3)
    }

    val pq = new mutable.PriorityQueue[(Int, Int, Int)]()(PQOrdering)
    //Add first column
    arr1.indices.foreach(i => {
      pq.enqueue((i, 0, arr1(i) + arr2(0)))
    })

    var i = 1
    while(i <= k && pq.nonEmpty) {
      val e = pq.dequeue()
      if(e._2 < m - 1) pq.enqueue((e._1, e._2 + 1, arr1(e._1) + arr2(e._2 + 1)))
      list += List(arr1(e._1), arr2(e._2))
      i += 1
    }
    list.toList
  }
}