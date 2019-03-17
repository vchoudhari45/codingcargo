package com.vc.medium

object L78 {
  def subsets(arr: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val n = arr.length
    def backtrack(start: Int, list: mutable.ArrayBuffer[Int]): Unit = {
      res += list.toList
      (start until n).foreach(i => {
        list += arr(i)
        backtrack(i + 1, list)
        list.remove(list.size - 1)
      })
    }
    backtrack(0, new mutable.ArrayBuffer[Int]())
    res.toList
  }
}
