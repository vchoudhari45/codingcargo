package com.vc.easy

object L806 {
  def numberOfLines(widths: Array[Int], s: String): Array[Int] = {
    var lines = 1
    var current = 0
    s.foreach(ch => {
      val width = widths(ch - 'a')
      if(current + width > 100) {
        lines += 1
        current = width
      }
      else {
        current = current + width
      }
    })
    Array(lines, current)
  }
}
