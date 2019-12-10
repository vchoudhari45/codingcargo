package com.vc.medium

object L540 {
  def singleNonDuplicate(arr: Array[Int]): Int = {
    var res = 0
    arr.foreach(x => {
      res ^= x
    })
    res
  }
}
