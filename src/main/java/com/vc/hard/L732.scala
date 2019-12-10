package com.vc.hard

class MyCalendarThree() {

  import scala.collection.JavaConverters._
  val timeline = new java.util.TreeMap[Int, Int]().asScala

  def book(start: Int, end: Int): Int = {
    timeline.put(start, timeline.getOrElse(start, 0) + 1)
    timeline.put(end, timeline.getOrElse(end, 0) - 1)
    var ongoing = 0
    var res = 0
    timeline.foreach(x => {
      ongoing += x._2
      res = Math.max(res, ongoing)
    })
    res
  }

}

/**
  * Your MyCalendarThree object will be instantiated and called as such:
  * var obj = new MyCalendarThree()
  * var param_1 = obj.book(start,end)
  */
