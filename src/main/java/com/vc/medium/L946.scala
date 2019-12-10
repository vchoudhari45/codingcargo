package com.vc.medium

object L946 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    var i = 0
    pushed.foreach(e => {
      st.push(e)
      while(st.nonEmpty && st.head == popped(i)) {
        st.pop
        i += 1
      }
    })
    i == pushed.length
  }
}
