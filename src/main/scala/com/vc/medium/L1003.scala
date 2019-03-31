package com.vc.medium

object L1003 {
  def isValid(S: String): Boolean = {
    import scala.collection.mutable
    val st = new mutable.Stack[Char]()
    S.foreach(x => {
      if(x == 'c') {
        if(st.isEmpty || st.pop != 'b') return false
        if(st.isEmpty || st.pop != 'a') return false
      }
      else st.push(x)
    })
    st.isEmpty
  }
}
