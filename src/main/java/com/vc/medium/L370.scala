package com.vc.medium

object L370 {
  def getModifiedArray(length: Int, updates: Array[Array[Int]]): Array[Int] = {
    val arr = new Array[Int](length)

    for(list <- updates) {
      val inc = list(2)
      arr(list(0)) += inc
      if(list(1) + 1 < length) arr(list(1) + 1) -= inc
    }

    var cur = 0
    (0 until length).foreach(i => {
      cur += arr(i)
      arr(i) = cur
    })
    arr
  }
}
