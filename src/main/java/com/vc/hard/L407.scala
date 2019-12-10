package com.vc.hard

object L407 {
  def trapRainWater(arr: Array[Array[Int]]): Int = {
    /**
            https://www.youtube.com/watch?v=cJayBq38VYw
            [
              [3,3,3,3],
              [3,1,1,2],
              [3,3,3,3]
            ]
      */
    object PQOrdering extends Ordering[(Int, Int, Int)] {
      def compare(x:(Int, Int, Int), y: (Int, Int, Int)): Int = y._1 - x._1
    }
    import scala.collection.mutable
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    val pq = new mutable.PriorityQueue[(Int, Int, Int)]()(PQOrdering)

    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length

    var row = 0
    var col = 0
    while(col < m) {
      pq += ((arr(row)(col), row, col))
      arr(row)(col) = -1
      col += 1
    }
    row += 1
    col -= 1

    while(row < n) {
      pq += ((arr(row)(col), row, col))
      arr(row)(col) = -1
      row += 1
    }
    col -= 1
    row -= 1

    while(col >= 0) {
      pq += ((arr(row)(col), row, col))
      arr(row)(col) = -1
      col -= 1
    }
    row -= 1
    col += 1

    while(row > 0) {
      pq += ((arr(row)(col), row, col))
      arr(row)(col) = -1
      row -= 1
    }

    var max = Int.MinValue
    var res = 0
    while(pq.nonEmpty) {
      val e = pq.dequeue()
      max = Math.max(max, e._1)
      dirs.foreach(dir => {
        val rowNew = dir._1 + e._2
        val colNew = dir._2 + e._3
        if(rowNew >= 0 && rowNew < n && colNew >= 0 && colNew < m && arr(rowNew)(colNew) != -1) {
          if(arr(rowNew)(colNew) < max) {
            res += (max - arr(rowNew)(colNew))
          }
          pq += ((arr(rowNew)(colNew), rowNew, colNew))
          arr(rowNew)(colNew) = -1
        }
      })
    }
    res
  }
}
