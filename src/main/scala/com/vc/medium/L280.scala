package com.vc.medium

object L280 {
  def wiggleSort(arr: Array[Int]): Unit = {
    (1 until arr.length).foreach(i => {
      if(
        (i % 2 == 1 && arr(i) < arr(i - 1)) ||
        (i % 2 == 0 && arr(i) > arr(i - 1))
      ) {
        val tmp = arr(i - 1)
        arr(i - 1) = arr(i)
        arr(i) = tmp
      }
    })
  }
}
