package com.vc.easy

object L475 {
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    scala.util.Sorting.quickSort(heaters)

    var res = 0
    houses.foreach(house => {
      val index = binarySearch(house)
      val leftDist = if(index - 1 >= 0) house - heaters(index - 1) else Int.MaxValue
      val rightDist = if(index < heaters.length) heaters(index) - house else Int.MaxValue
      res = Math.max(res, Math.min(leftDist, rightDist))
    })

    def binarySearch(n: Int): Int = {
      var lo = 0
      var hi = heaters.length - 1
      while(lo <= hi) {
        val mid = lo + (hi - lo) / 2
        if(heaters(mid) > n) hi = mid - 1
        else if(heaters(mid) < n) lo = mid + 1
        else return mid
      }
      lo
    }
    res
  }
}
