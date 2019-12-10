package com.vc.easy

object L20 {
  def isValid(s: String): Boolean = {
    import scala.collection.mutable
    val st = new mutable.Stack[Char]()
    s.foreach({
      case '(' => st.push('(')
      case '{' => st.push('{')
      case '[' => st.push('[')
      case ')' => if(st.isEmpty || st.pop != '(') return false
      case '}' => if(st.isEmpty || st.pop != '{') return false
      case ']' => if(st.isEmpty || st.pop != '[') return false
    })
    st.isEmpty
  }
}
