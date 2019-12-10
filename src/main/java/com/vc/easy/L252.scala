package com.vc.easy

class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

object L252 {
  def canAttendMeetings(intervals: Array[Interval]): Boolean = {
    val intervalSorted = intervals.sortBy(_.end)
    (0 until intervalSorted.length - 1).foreach(i => {
      val prev = intervalSorted(i)
      val current = intervalSorted(i + 1)
      if(prev.end > current.start) return false
    })
    true
  }
}
