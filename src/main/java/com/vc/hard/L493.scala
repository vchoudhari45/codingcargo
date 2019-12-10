package com.vc.hard

object L493 {
  def reversePairs(nums: Array[Int]): Int = {
    var count = 0
    def mergeSort(arr: Array[Int]): Array[Int] = {
      if(arr.length <= 1) return arr

      val lo = 0
      val hi = arr.length
      val mid = lo + (hi - lo) / 2
      val left = mergeSort(arr.slice(0, mid))
      val right = mergeSort(arr.slice(mid, hi))

      var leftCount = 0
      var rightCount = 0
      while(leftCount < left.length) {
        val leftElement = left(leftCount) / 2.0
        while(rightCount < right.length && leftElement > right(rightCount)) rightCount += 1
        count += rightCount
        leftCount += 1
      }

      leftCount = 0
      rightCount = 0
      while(leftCount < left.length && rightCount < right.length) {
        val leftElement = left(leftCount)
        val rightElement = right(rightCount)
        if(leftElement < rightElement) {
          arr(leftCount + rightCount) = leftElement
          leftCount += 1
        }
        else {
          arr(leftCount + rightCount) = rightElement
          rightCount += 1
        }
      }

      while(leftCount < left.length) {
        arr(leftCount + rightCount) = left(leftCount)
        leftCount += 1
      }

      while(rightCount < right.length) {
        arr(leftCount + rightCount) = right(rightCount)
        rightCount += 1
      }
      arr
    }
    mergeSort(nums)
    count
  }
}



