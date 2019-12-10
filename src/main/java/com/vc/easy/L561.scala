package com.vc.easy

object L561 {
  def arrayPairSum(nums: Array[Int]): Int = {
    scala.util.Sorting.quickSort(nums)
    var sum = 0
    (nums.indices by 2).foreach(i => {
      sum += nums(i)
    })
    sum
  }
}
