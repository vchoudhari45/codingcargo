package com.vc.easy

object L849 {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var i = 0
    val n = seats.length
    var maxDistance = 0
    var left = -1
    while(i < n) {
      if(seats(i) != 0) {
        if(left == -1) maxDistance = Math.max(maxDistance, i)
        else maxDistance = Math.max(maxDistance, (i - left) / 2)
        left = i
      }
      i += 1
    }
    if(seats(n - 1) == 0) maxDistance = Math.max(maxDistance, n - 1 - left)
    maxDistance
  }
}
