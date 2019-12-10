package com.vc.easy

class MovingAverage(size: Int) {

  /** Initialize your data structure here. */
  import scala.collection.mutable
  val q = new mutable.Queue[Int]()

  def next(value: Int): Double = {
    if(q.size == size) {
      q.dequeue()
    }
    q.enqueue(value)
    q.sum.toDouble / q.size.toDouble
  }

}

/**
  * Your MovingAverage object will be instantiated and called as such:
  * var obj = new MovingAverage(size)
  * var param_1 = obj.next(`val`)
  */
