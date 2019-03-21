package com.vc.medium

object L131 {
  def partition(s: String): List[List[String]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[String]]()
    val list = new mutable.ArrayBuffer[String]()
    val n = s.length
    def isPalindrome(start: Int, end: Int): Boolean = {
      var low = start
      var hi = end
      while(low < hi) {
        if(s(low) != s(hi)) return false
        low += 1
        hi -= 1
      }
      true
    }
    def solve(start: Int): Unit = {
      if(n == start) res += list.toList
      else {
        (start until n).foreach(i => {
          if(isPalindrome(start, i)) {
            list += s.substring(start, i + 1)
            solve(i + 1)
            list.remove(list.size - 1)
          }
        })
      }
    }
    solve(0)
    res.toList
  }
}