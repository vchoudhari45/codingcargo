package com.vc.medium

class L451 {
  object PQOrdering extends Ordering[(Char, Int)] {
    def compare(x: (Char, Int), y: (Char, Int)): Int = x._2.compareTo(y._2)
  }
  def frequencySort(s: String): String = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    s.foreach(x => {
      val count = map.getOrElse(x, 0)
      map.put(x, count + 1)
    })

    val pq = new mutable.PriorityQueue[(Char, Int)]()(PQOrdering)
    map.foreach(x => {
      pq.enqueue(x)
    })

    val str = new mutable.StringBuilder()
    while(pq.nonEmpty) {
      val e = pq.dequeue()
      (0 until e._2).foreach(_ => str.append(e._1))
    }
    str.toString
  }
}
