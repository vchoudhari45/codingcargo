package com.vc.easy

object L844 {
  def backspaceCompare(S: String, T: String): Boolean = {
    import scala.collection.mutable
    def solve(str: String): String = {
      val st = new mutable.Stack[Char]()
      str.foreach(ch => {
        if(ch == '#') {
          if(st.nonEmpty) st.pop
        }
        else st.push(ch)
      })
      st.mkString("")
    }
    solve(S) == solve(T)
  }
}
