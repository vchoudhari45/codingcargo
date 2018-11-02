package com.vc

object L852 {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    var max = arr(0)
    var maxIndex = 0
    arr.indices.foreach(i => {
      if(max < arr(i)) {
        max = arr(i)
        maxIndex = i
      }
    })
    maxIndex
  }
}
