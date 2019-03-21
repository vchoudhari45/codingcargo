package com.vc.medium

object L39 {
  def combinationSum(arr: Array[Int], target: Int): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ArrayBuffer[Int]()
    val n = arr.length
    def solve(start: Int, remain: Int): Unit = {
      if(remain == 0) res += list.toList
      else if(remain > 0){
        (start until n).foreach(i => {
          list += arr(i)
          solve(i, remain - arr(i))
          list.remove(list.length - 1)
        })
      }
    }
    solve(0, target)
    res.toList
  }
}