package com.vc.hard

object L315 {
  def countSmaller(arr: Array[Int]): List[Int] = {
    val n = arr.length
    val res = new Array[Int](n)
    if(n == 0) return res.toList
    val indexed = arr.zipWithIndex
    def mergeSort(arr: Array[(Int, Int)]): Array[(Int, Int)] = {
      if(arr.length <= 1) return arr

      val lo = 0
      val hi = arr.length
      val mid = lo + (hi - lo) / 2
      val left = mergeSort(arr.slice(0, mid))
      val right = mergeSort(arr.slice(mid, hi))

      var leftCount = 0
      var rightCount = 0

      while(leftCount < left.length && rightCount < right.length) {
        val leftElement = left(leftCount)
        val rightElement = right(rightCount)

        if(leftElement._1 <= rightElement._1) {
          arr(leftCount + rightCount) = leftElement
          leftCount += 1
          //This is main Idea when you put leftElement in sortedArray while merging
          //Update result with rightCount
          //RightCount is how many elements from rightSide are included in the sorted array
          //before currentElement
          res(leftElement._2) += rightCount
        }
        else {
          arr(leftCount + rightCount) = rightElement
          rightCount += 1
        }
      }

      while(leftCount < left.length) {
        arr(leftCount + rightCount) = left(leftCount)
        res(left(leftCount)._2) += rightCount
        leftCount += 1
      }

      while(rightCount < right.length) {
        arr(leftCount + rightCount) = right(rightCount)
        rightCount += 1
      }
      arr
    }
    mergeSort(indexed)
    res.toList
  }
}