package com.vc.medium

object L921 {
  def minAddToMakeValid(str: String): Int = {
    import scala.collection.mutable
    val st = new mutable.Stack[Char]()

    str.foreach({
      case '(' => st.push('(')
      case  ')' => {
        if(st.nonEmpty && st.head == '(') st.pop
        else st.push(')')
      }
    })
    st.size
  }
}
