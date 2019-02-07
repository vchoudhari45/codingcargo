package com.vc.medium

class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

object L986 {
  def intervalIntersection(A: Array[Interval], B: Array[Interval]): Array[Interval] = {
    val nA = A.length
    val nB = B.length
    var i = 0
    var j = 0
    import scala.collection.mutable
    val arr = new mutable.ArrayBuffer[Interval]()
    while(i < nA && j < nB) {
      if(A(i).start > B(j).end) {
        j += 1
      }
      else if(B(j).start > A(i).end) {
        i += 1
      }
      else {
        val ans = new Interval()
        ans.start = Math.max(A(i).start, B(j).start)
        ans.end = Math.min(A(i).end, B(j).end)
        arr += ans
        if(A(i).end > B(j).end) j += 1 else i += 1
      }
    }
    arr.toArray
  }
}
