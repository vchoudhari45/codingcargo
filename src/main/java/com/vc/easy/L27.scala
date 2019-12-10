package com.vc.easy

object L27 {
  def removeElement(nums: Array[Int], value: Int): Int = {
    var i = 0
    nums.foreach(x => {
      if(x != value) {
        nums(i) = x
        i += 1
      }
    })
    i
  }
}
