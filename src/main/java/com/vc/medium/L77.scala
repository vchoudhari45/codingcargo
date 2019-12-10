package com.vc.medium

object L77 {
  def combine(n: Int, k: Int): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    def solve(cur: mutable.ListBuffer[Int], pos: Int, count: Int): Unit = {
      if(count == k) res += cur.toList
      else {
        (pos to n).foreach(i => {
          cur += i
          solve(cur, i + 1, count + 1)
          cur.remove(cur.length - 1)
        })
      }
    }
    solve(new mutable.ListBuffer[Int], 1, 0)
    res.toList
  }
}
