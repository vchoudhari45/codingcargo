package com.vc.hard

object L57 {
  def insert(arr: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    var i = 0
    val n = arr.length
    import scala.collection.mutable
    val newArr = new mutable.ArrayBuffer[Array[Int]]()
    val start = newInterval(0)
    val end = newInterval(1)

    var mergeStart = start
    while(i < n && start > arr(i)(1)) {
      newArr += arr(i)
      i += 1
    }
    mergeStart = if(i < n) Math.min(start, arr(i)(0)) else start

    var mergeEnd = end
    while(i < n && end >= arr(i)(0)) {
      i += 1
    }
    mergeEnd = if(i - 1 >= 0) Math.max(end, arr(i - 1)(1)) else end

    newArr += Array(mergeStart, mergeEnd)
    while(i < n) {
      newArr += arr(i)
      i += 1
    }
    newArr.toArray
  }
}