package com.vc.medium

object L260 {
  def singleNumber(arr: Array[Int]): Array[Int] = {
    var diff = 0
    arr.foreach(x => diff ^= x)
    diff &= -diff

    val res = new Array[Int](2)
    arr.foreach(x => {
      if((x & diff) == 0) res(0) ^= x
      else res(1) ^= x
    })
    res
  }
}