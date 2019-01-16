package com.vc.medium

object L969 {
  def pancakeSort(arr: Array[Int]): List[Int] = {
    if(arr.length == 1) return arr.toList

    def reverse(start: Int, end: Int): Unit = {
      var from = start
      var to = end
      while(from < to) {
        val tmp = arr(from)
        arr(from) = arr(to)
        arr(to) = tmp
        from += 1
        to -= 1
      }
    }

    def findMaxIdx(end: Int): Int = {
      var maxIdx = 0
      var max = arr(0)
      (1 to end).foreach(i => {
        if(arr(i) > max) {
          max = arr(i)
          maxIdx = i
        }
      })
      maxIdx
    }

    var end = arr.length - 1
    import scala.collection.mutable
    val res = new mutable.ArrayBuffer[Int]()
    while(end > 0) {
      val maxIdx = findMaxIdx(end)
      res += maxIdx + 1
      res += end + 1
      reverse(0, maxIdx)
      reverse(0, end)
      end -= 1
    }
    res.toList
  }
}
