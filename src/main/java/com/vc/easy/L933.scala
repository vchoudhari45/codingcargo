package com.vc.easy

class RecentCounter() {

  import scala.collection.mutable
  val q = new mutable.Queue[Int]()

  def ping(t: Int): Int = {
    while(q.nonEmpty && t - q.head > 3000) q.dequeue
    q.enqueue(t)
    q.size
  }

}
