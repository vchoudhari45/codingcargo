package com.vc.medium

object L1024 {
  object ClipsOrdering extends Ordering[Array[Int]] {
    override def compare(x: Array[Int], y: Array[Int]): Int = x(0).compareTo(y(0))
  }
  def videoStitching(clips: Array[Array[Int]], T: Int): Int = {
    scala.util.Sorting.quickSort(clips)(ClipsOrdering)
    val n = clips.length
    var end = 0
    var count = 0
    var i = 0
    while(i < n) {
      if(clips(i)(0) > end) return -1
      var maxEnd = 0
      while(i < n && clips(i)(0) <= end) {
        maxEnd = Math.max(maxEnd, clips(i)(1))
        i += 1
      }
      end = maxEnd
      count += 1
      if(end >= T) return count
    }
    if(end >= T) count else -1
  }
}