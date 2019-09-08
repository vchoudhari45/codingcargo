package com.vc.hard

class MedianFinder() {

  /** initialize your data structure here. */
  import scala.collection.mutable
  object PQOrdering extends Ordering[Int] {
    def compare(x: Int, y: Int): Int = y.compareTo(x)
  }

  val maxHeap = new mutable.PriorityQueue[Int]()(PQOrdering)
  val minHeap = new mutable.PriorityQueue[Int]()
  def addNum(num: Int) {
    minHeap += num
    maxHeap += minHeap.dequeue
    if(minHeap.size < maxHeap.size) {
      minHeap += maxHeap.dequeue
    }
  }

  def findMedian(): Double = {
    if(maxHeap.size < minHeap.size) minHeap.head
    else (maxHeap.head + minHeap.head) / 2.0
  }
}

/**
  * Your MedianFinder object will be instantiated and called as such:
  * var obj = new MedianFinder()
  * obj.addNum(num)
  * var param_2 = obj.findMedian()
  */