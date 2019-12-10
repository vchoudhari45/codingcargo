package com.vc.medium

object L215 {
  def findKthLargest(arr: Array[Int], k: Int): Int = {
    import scala.collection.mutable
    val pq = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

    var i = 0
    val n = arr.length
    while(i < n) {
      pq.enqueue(arr(i))
      if(pq.size > k) pq.dequeue
      i += 1
    }
    pq.head
  }
}
