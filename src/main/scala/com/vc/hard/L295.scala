package com.vc.hard

class MedianFinder() {

  /** initialize your data structure here. */

  import scala.collection.mutable

  val small = new mutable.PriorityQueue[Int]()
  val large = new mutable.PriorityQueue[Int]()

  def addNum(num: Int) {
    large += num
    small += -1 * large.dequeue
    if(large.size < small.size) {
      large += -1 * small.dequeue
    }
  }

  def findMedian(): Double = {
    if(large.size > small.size) large.head
    else (large.head - small.head) / 2.0
  }

}

/**
  * Your MedianFinder object will be instantiated and called as such:
  * var obj = new MedianFinder()
  * obj.addNum(num)
  * var param_2 = obj.findMedian()
  */