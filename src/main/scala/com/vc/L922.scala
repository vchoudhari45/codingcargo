package com.vc

object L922 {
  def sortArrayByParityII(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    var evenIdx = 0
    var oddIdx = 1
    while(evenIdx < n && oddIdx < n) {
      while(evenIdx < n && arr(evenIdx) % 2 == 0) evenIdx += 2
      while(oddIdx < n && arr(oddIdx) % 2 != 0) oddIdx += 2
      if(evenIdx < n && oddIdx < n) {
        val tmp = arr(oddIdx)
        arr(oddIdx) = arr(evenIdx)
        arr(evenIdx) = tmp
      }
    }
    arr
  }
}
