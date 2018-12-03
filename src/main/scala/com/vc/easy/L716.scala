package com.vc.easy

class MaxStack() {

  /** initialize your data structure here. */
  import scala.collection.mutable
  val st = new mutable.Stack[Int]()

  def push(x: Int): Unit = st.push(x)

  def pop(): Int = st.pop

  def top(): Int = st.top

  def peekMax(): Int = st.max

  def popMax(): Int = {
    val max = st.max
    val s = new mutable.Stack[Int]()
    while(st.head != max) {
      s.push(st.pop)
    }
    st.pop
    while(s.nonEmpty) {
      st.push(s.pop)
    }
    max
  }
}

/**
  * Your MaxStack object will be instantiated and called as such:
  * var obj = new MaxStack()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.peekMax()
  * var param_5 = obj.popMax()
  */
