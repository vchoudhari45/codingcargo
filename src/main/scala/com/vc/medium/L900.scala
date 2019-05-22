package com.vc.medium

class RLEIterator(arr: Array[Int]) {

  var i = 0
  val size = arr.length

  def next(n: Int): Int = {
    var nVar = n
    while(i < size && nVar > arr(i)) {
      nVar -= arr(i)
      i += 2
    }

    if(i >= size) -1
    else {
      arr(i) -= nVar
      arr(i + 1)
    }
  }

}
