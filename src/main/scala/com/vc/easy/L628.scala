package com.vc.easy

object L628 {
  def maximumProduct(arr: Array[Int]): Int = {
    scala.util.Sorting.quickSort(arr)
    val n = arr.length
    var res = 1
    var count = 3
    if(arr(0) * arr(n - 1) >= 0 || count == n) {
      var j = n - 1
      while(count > 0) {
        res = res * arr(j)
        j -= 1
        count -= 1
      }
    }
    else {
      var l = 0
      var r = n - 1
      while(count > 0) {
        if(count % 2 == 1) {
          res = res * arr(r)
          r -= 1
        }
        else {
          val maxValue = arr(r - 1) * arr(r)
          val minValue = arr(l + 1) * arr(l)
          if(maxValue > minValue) {
            res = res * maxValue
            r -= 2
          }
          else {
            res = res * minValue
            l += 2
          }
          count -= 1
        }
        count -= 1
      }
    }
    res
  }
}
