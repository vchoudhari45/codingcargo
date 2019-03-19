package com.vc.medium

object L90 {
  def subsetsWithDup(arr: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ArrayBuffer[Int]()
    val n = arr.length
    scala.util.Sorting.quickSort(arr)
    def solve(start: Int): Unit = {
      res += list.toList
      (start until n).foreach(i => {
        if(!(i > start && arr(i) == arr(i - 1))) {
          list += arr(i)
          solve(i + 1)
          list.remove(list.size - 1)
        }
      })
    }
    solve(0)
    res.toList
  }
}
