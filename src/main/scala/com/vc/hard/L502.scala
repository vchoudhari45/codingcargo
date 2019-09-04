package com.vc.hard

object L502 {
  def findMaximizedCapital(k: Int, W: Int, profits: Array[Int], capital: Array[Int]): Int = {
    import scala.collection.mutable

    object PQCapOrdering extends Ordering[(Int, Int)] {
      def compare(x: (Int, Int), y: (Int, Int)): Int = {
        y._1.compareTo(x._1)
      }
    }

    object PQProfitOrdering extends Ordering[(Int, Int)] {
      def compare(x: (Int, Int), y: (Int, Int)): Int = {
        x._2.compareTo(y._2)
      }
    }

    val pqCap = new mutable.PriorityQueue[(Int, Int)]()(PQCapOrdering)
    val pqProfit = new mutable.PriorityQueue[(Int, Int)]()(PQProfitOrdering)

    val n = profits.length
    var i = 0
    while(i < n) {
      pqCap += ((capital(i), profits(i)))
      i += 1
    }

    i = 0
    var res = W
    while(i < k) {
      while(pqCap.nonEmpty && pqCap.head._1 <= res) {
        pqProfit += pqCap.dequeue
      }
      if(pqProfit.isEmpty) return res

      res += pqProfit.dequeue._2
      i += 1
    }
    res
  }
}