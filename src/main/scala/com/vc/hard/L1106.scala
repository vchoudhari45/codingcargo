package com.vc.hard

object L1106 {
  def parseBoolExpr(expression: String): Boolean = {
    import scala.collection.mutable
    def helper(operation: Char, list: mutable.ListBuffer[Boolean]): Boolean = {
      operation match {
        case '!' => !list.head
        case '|' => list.contains(true)
        case '&' => !list.contains(false)
      }
    }
    val st = new mutable.Stack[Char]()
    expression.foreach(ch => {
      if(ch == ')') {
        val list = new mutable.ListBuffer[Boolean]
        while(st.head != '!' && st.head != '&' && st.head != '|') {
          val popped = st.pop
          if(popped == 't') list += true
          else if(popped == 'f') list += false
        }
        val res = helper(st.pop, list)
        if(res) st.push('t') else st.push('f')
      }
      else if(ch != ',' && ch != '(') st.push(ch)
    })
    st.pop == 't'
  }
}