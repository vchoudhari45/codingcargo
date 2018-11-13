package com.vc.easy

object Solution {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    def binarySearch(start:Int, target:Int): Int = {
      var lo = start
      var hi = numbers.length - 1
      while(lo <= hi) {
        val mid = lo + (hi - lo) / 2
        if(numbers(mid) > target) {
          hi = mid - 1
        }
        else if(numbers(mid) < target) {
          lo = mid + 1
        }
        else return mid
      }
      -1
    }

    val arr = new Array[Int](2)
    numbers.indices.foreach(i => {
      val mid = binarySearch(i + 1, target - numbers(i))
      if(mid != -1) {
        arr(0) = i + 1
        arr(1) = mid + 1
      }
    })
    arr
  }
}
