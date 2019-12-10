package com.vc.hard

object L798 {
  def bestRotation(arr: Array[Int]): Int = {
    val n = arr.length
    //We get one point if ValueAtIndex <= Index
    val intervals = new Array[Int](n)
    arr.indices.foreach(i => {
      //So for each index will have at least 1 point
      val intervalStart = (i + 1) % n
      intervals(intervalStart) += 1

      //End of the interval is decided by value at the index
      //for example [2, 4, 1, 3, 0]
      //Value at 0th index is 2
      //so to earn the point from 2 it should either be at 2nd, 3rd or 4th index
      //which makes the end of interval as (i + 1 + n - arr(i)) % n
      // i + 1 because let's consider the value at 0th location is 0
      // which will give it one point for all the values starting from i + 1 until n
      // But since value at 0th location is 2 we substract that value
      val intervalEnd = (i + 1 + n - arr(i) + n) % n
      intervals(intervalEnd) -= 1
    })

    //Now problem becomes very similar to overlapping meeting problem
    var maxCount = -1
    var count = 0
    var rotation = 0
    intervals.indices.foreach(i => {
      count += intervals(i)
      if(maxCount < count) {
        maxCount = count
        rotation = i
      }
    })
    rotation
  }
}