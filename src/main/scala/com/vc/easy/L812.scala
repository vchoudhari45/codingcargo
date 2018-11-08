package com.vc.easy

object L812 {
  def largestTriangleArea(points: Array[Array[Int]]): Double = {
    val n = points.length
    var max = 0.0
    (0 until n - 2).foreach(i => {
      (0 until n - 1).foreach(j => {
        (0 until n).foreach(k => {
          max = Math.max(max, calculateArea(points(i), points(j), points(k)))
        })
      })
    })
    max
  }

  private def calculateArea(a:Array[Int], b: Array[Int], c: Array[Int]): Double = {
    Math.abs(
      a(0) * (b(1) - c(1)) +
      b(0) * (c(1) - a(1)) +
      c(0) * (a(1) - b(1))
    ) / 2.0
  }
}