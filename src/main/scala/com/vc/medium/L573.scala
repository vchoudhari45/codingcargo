package com.vc.medium

object L573 {
  def minDistance(height: Int, width: Int, tree: Array[Int], squirrel: Array[Int], nuts: Array[Array[Int]]): Int = {
    var sum = 0
    var maxDiff = 0
    nuts.foreach(nut => {
      val distNutToTree = Math.abs(nut(0) - tree(0)) + Math.abs(nut(1) - tree(1))
      sum += 2 * distNutToTree
      maxDiff = Math.max(maxDiff, distNutToTree - Math.abs(nut(0) - squirrel(0)) - Math.abs(nut(1) - squirrel(1)))
    })
    sum -= maxDiff
    sum
  }
}
