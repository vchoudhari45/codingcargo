package com.vc.easy

object L168 {
  def convertToTitle(n: Int): String = {
    import scala.collection.mutable
    val st = new mutable.Stack[Char]()
    var nVar = n
    while(nVar > 0) {
      val ch = ((nVar - 1) % 26 + 'A').toChar
      nVar = (nVar - 1) / 26
      st.push(ch)
    }
    st.mkString("")
  }
}
