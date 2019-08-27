package com.vc.hard

object L1168 {
  def minCostToSupplyWater(n: Int, wells: Array[Int], pipes: Array[Array[Int]]): Int = {
    /**
            Krushal's Algorithm
            [1, 2, 2]
            [
                [1, 2, 1],
                [2, 3, 1]
            ]

            (0, 1) -> 1
            (1, 2) -> 1
            (2, 3) -> 1
            (0, 2) -> 2
            (0, 3) -> 2
      */

    object PQOrdering extends Ordering[(Int, Int, Int)] {
      def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3.compareTo(x._3)
    }

    import scala.collection.mutable
    val edges = new mutable.PriorityQueue[(Int, Int, Int)]()(PQOrdering)
    wells.indices.foreach(i => {
      edges += ((0, i + 1, wells(i)))
    })

    pipes.foreach(pipe => {
      edges += ((pipe(0), pipe(1), pipe(2)))
    })

    val uf = new Array[Int](n + 1)
    uf.indices.foreach(i => uf(i) = i)
    def union(a: Int, b: Int): Unit = uf(a) = b
    def find(n: Int): Int = {
      if(uf(n) == n) n
      else find(uf(n))
    }
    var res = 0
    while(edges.nonEmpty) {
      val e = edges.dequeue
      val a = find(e._1)
      val b = find(e._2)
      val weight = e._3
      if(a != b) {
        res += weight
        union(a, b)
      }
    }
    res
  }
}