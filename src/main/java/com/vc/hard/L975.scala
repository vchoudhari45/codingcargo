package com.vc.hard

object L975 {
  def oddEvenJumps(arr: Array[Int]): Int = {
    val n = arr.length

    var i = n - 1
    val map = new java.util.TreeMap[Int, Int]()
    val lower = new Array[Boolean](n)
    val higher = new Array[Boolean](n)

    map.put(arr(i), i)
    lower(i) = true
    higher(i) = true

    var res = 1
    i -= 1
    while(i >= 0) {
      val lo = map.floorEntry(arr(i))
      val hi = map.ceilingEntry(arr(i))

      if(lo != null) lower(i) = higher(lo.getValue)
      if(hi != null) higher(i) = lower(hi.getValue)

      if(higher(i)) res += 1

      map.put(arr(i), i)
      i -= 1
    }
    res
  }
}