package com.vc.easy

object L455 {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    scala.util.Sorting.quickSort(g)
    scala.util.Sorting.quickSort(s)
    var gi = 0
    var si = 0
    val n = g.length
    val m = s.length
    while(gi < n && si < m) {
      if(g(gi) <= s(si)) {
        gi += 1
      }
      si += 1
    }
    gi
  }
}
