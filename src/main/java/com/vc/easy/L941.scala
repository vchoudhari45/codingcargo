package com.vc.easy

object L941 {
  def validMountainArray(arr: Array[Int]): Boolean = {
    var i = 0
    val n = arr.length - 1
    var j = n - 1
    while(i < n && arr(i) > arr(i + 1)) i += 1
    while(j > 0 && arr(j - 1) > arr(j)) j -= 1
    i > 0 && i == j && j < n - 1
  }
}
