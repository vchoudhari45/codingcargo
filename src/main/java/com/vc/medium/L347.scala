package com.vc.medium

object L347 {
  object PQOrdering extends Ordering[(Int, Int)] {
    def compare(x:(Int, Int), y:(Int, Int)): Int = x._2.compareTo(y._2)
  }
  def topKFrequent(arr: Array[Int], k: Int): List[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    val pq = new mutable.PriorityQueue[(Int, Int)]()(PQOrdering)
    arr.foreach(x => map.put(x, map.getOrElse(x, 0) + 1))
    map.foreach(x => pq += x)
    val list = new mutable.ListBuffer[Int]()
    var i = 0
    while(i < k) {
      list += pq.dequeue._1
      i += 1
    }
    list.toList
  }
}
