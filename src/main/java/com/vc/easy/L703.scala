package com.vc.easy

class L703(_k: Int, _nums: Array[Int]) {

  import scala.collection.mutable
  val pq = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
  _nums.map(add)

  def add(value: Int): Int = {
    if(pq.size < _k) pq.enqueue(value)
    else if(pq.head < value) {
      pq.dequeue
      pq.enqueue(value)
    }
    pq.head
  }
}

/**
  * Your KthLargest object will be instantiated and called as such:
  * var obj = new KthLargest(k, nums)
  * var param_1 = obj.add(`val`)
  */
