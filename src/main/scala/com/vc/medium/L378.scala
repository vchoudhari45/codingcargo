package com.vc.medium

object L378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    import scala.collection.mutable
    object PQOrdering extends Ordering[(Int, Int)] {
      def compare(p1:(Int, Int), p2: (Int, Int)): Int = {
        matrix(p2._1)(p2._2).compareTo(matrix(p1._1)(p1._2))
      }
    }

    val pq = new mutable.PriorityQueue[(Int, Int)]()(PQOrdering)
    val n = matrix.length
    if(n == 0) return 0
    val m = matrix(0).length

    //Insert first column in Priority Queue
    matrix.indices.foreach(i => {
      pq.enqueue((i, 0))
    })

    var i = 1
    while(i < k) {
      val e = pq.dequeue()
      println(s"$i => ${matrix(e._1)(e._2)}")
      if(e._2 < m - 1) pq.enqueue((e._1, e._2 + 1))
      i += 1
    }
    matrix(pq.head._1)(pq.head._2)
  }
}