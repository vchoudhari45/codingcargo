package com.vc.medium

class MyCalendar() {

  import java.util.TreeMap
  val map = new TreeMap[Integer, Integer]()

  def book(start: Int, end: Int): Boolean = {
    val lowerKey = map.lowerKey(end)
    if(lowerKey == null || map.get(lowerKey) <= start) {
      map.put(start, end)
      return true
    }
    false
  }

}

/**
  * Your MyCalendar object will be instantiated and called as such:
  * var obj = new MyCalendar()
  * var param_1 = obj.book(start,end)
  */
