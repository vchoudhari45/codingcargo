package com.vc.easy

object L492 {
  def constructRectangle(area: Int): Array[Int] = {
    if(area == 0) return Array(0, 0)
    var w = Math.sqrt(area).toInt
    while(area % w != 0) w -= 1
    Array(area / w, w)
  }
}
