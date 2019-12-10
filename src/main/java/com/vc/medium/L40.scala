package com.vc.medium

object L40 {
  def combinationSum2(arr: Array[Int], target: Int): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ArrayBuffer[Int]()
    val n = arr.length
    scala.util.Sorting.quickSort(arr)
    def solve(start: Int, remain: Int): Unit = {
      if(remain == 0) res += list.toList
      else if(remain > 0) {
        (start until n).foreach(i => {
          if(!(i > start && arr(i) == arr(i - 1)))  {
            list += arr(i)
            solve(i + 1, remain - arr(i))
            list.remove(list.length - 1)
          }
        })
      }
    }
    solve(0, target)
    res.toList
  }
}