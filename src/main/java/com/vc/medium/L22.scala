package com.vc.medium

object L22 {
  def generateParenthesis(n: Int): List[String] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[String]()
    def solve(s: String, open: Int, close: Int): Unit = {
      if(s.length == n * 2) list += s
      else {
        if(open < n)
          solve(s + "(", open + 1, close)
        if(close < open)
          solve(s + ")", open, close + 1)
      }
    }
    solve("", 0, 0)
    list.toList
  }
}