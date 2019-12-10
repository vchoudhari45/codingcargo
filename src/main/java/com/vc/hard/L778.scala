package com.vc.hard

object L778 {
  def swimInWater(arr: Array[Array[Int]]): Int = {
    /**
          [
                [0,1,2,3,4],
                [24,23,22,21,5],
                [12,13,14,15,16],
                [11,17,18,19,20],
                [10,9,8,7,6]
            ]
      */
    import scala.collection.mutable
    object PQOrdering extends Ordering[(Int, Int, Int)] {
      def compare(x: (Int, Int, Int), y: (Int, Int, Int)) : Int = y._1 - x._1
    }
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    var res = 0
    val pq = new mutable.PriorityQueue[(Int, Int, Int)]()(PQOrdering)
    val n = arr.length
    if(n == 0) return res
    val m = arr(0).length
    pq += ((arr(0)(0), 0, 0))
    arr(0)(0) = -1
    while(pq.nonEmpty) {
      val e = pq.dequeue()
      res = Math.max(res, e._1)
      val x = e._2
      val y = e._3
      if(x == n - 1 && y == m - 1) return res
      dirs.foreach(dir => {
        val xNew = x + dir._1
        val yNew = y + dir._2
        if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && arr(xNew)(yNew) != -1) {
          pq += ((arr(xNew)(yNew), xNew, yNew))
          arr(xNew)(yNew) = -1
        }
      })
    }
    res
  }
}