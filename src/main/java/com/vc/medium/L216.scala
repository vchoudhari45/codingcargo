package com.vc.medium

object L216 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ListBuffer[Int]()
    def solve(start:Int, remain: Int, count: Int): Unit = {
      if(remain == 0 && count == 0) res += list.toList
      else if(remain > 0 && count > 0) {
        (start to 9).foreach(i => {
          list += i
          solve(i + 1, remain - i, count - 1)
          list.remove(list.length - 1)
        })
      }
    }
    solve(1, n, k)
    res.toList
  }
}
