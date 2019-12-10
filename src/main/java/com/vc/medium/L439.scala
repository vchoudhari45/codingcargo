package com.vc.medium

object L439 {
  def parseTernary(expression: String): String = {
    import scala.collection.mutable
    val st = new mutable.Stack[Char]()
    var i = expression.length - 1
    while(i >= 0) {
      val c = expression(i)
      if(st.nonEmpty && st.head == '?') {
        st.pop
        val first = st.pop
        st.pop
        val second = st.pop
        if(c == 'T') st.push(first)
        else st.push(second)
      }
      else st.push(c)
      i -= 1
    }
    st.head.toString
  }
}