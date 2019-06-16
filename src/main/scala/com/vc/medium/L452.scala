package com.vc.medium

object L452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    object BalloonSorting extends Ordering[Array[Int]] {
      def compare(x: Array[Int], y: Array[Int]): Int = x(1).compareTo(y(1))
    }
    if(points.length == 0) return 0
    scala.util.Sorting.quickSort(points)(BalloonSorting)
    var arrowCount = 1
    var arrowPos = points(0)(1)
    var i = 0
    val n = points.length
    while(i < n) {
      if(arrowPos < points(i)(0)) {
        arrowCount += 1
        arrowPos = points(i)(1)
      }
      i += 1
    }
    arrowCount
  }
}
