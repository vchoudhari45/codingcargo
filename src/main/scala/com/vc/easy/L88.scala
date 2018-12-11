package com.vc.easy

object L88 {
  def merge(arr1: Array[Int], m: Int, arr2: Array[Int], n: Int): Unit = {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    while(i >= 0 && j >= 0) {
      if(arr1(i) > arr2(j)) {
        arr1(k) = arr1(i)
        i -= 1
      }
      else {
        arr1(k) = arr2(j)
        j -= 1
      }
      k -= 1
    }

    while(i >= 0) {
      arr1(k) = arr1(i)
      i -= 1
      k -= 1
    }

    while(j >= 0) {
      arr1(k) = arr2(j)
      j -= 1
      k -= 1
    }
  }
}
