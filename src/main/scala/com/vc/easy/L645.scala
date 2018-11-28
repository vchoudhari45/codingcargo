package com.vc.easy

object L645 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val res = Array(0, 0)
    nums.foreach(x => {
      if(nums(Math.abs(x) - 1) < 0) res(0) = Math.abs(x)
      else nums(Math.abs(x) - 1) *= -1
    })
    nums.indices.foreach(i => {
      if(nums(i) > 0) {
        res(1) = i + 1
        return res
      }

    })
    res
  }
}