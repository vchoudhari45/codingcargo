package com.vc.easy

object L830 {
  def largeGroupPositions(s: String): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val n = s.length
    var start = 0
    var end = 1
    while(end < n) {
      if(s(start) != s(end)) {
        if(end - start >= 3) res += List(start, end - 1)
        start = end
      }
      end += 1
    }
    if(end - start >= 3) res += List(start, end - 1)
    res.toList
  }
}
