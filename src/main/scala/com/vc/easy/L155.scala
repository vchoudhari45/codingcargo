package com.vc.easy

class MinStack() {

  /** initialize your data structure here. */
  import scala.collection.mutable
  val st = new mutable.Stack[(Int, Int)]

  def push(x: Int): Unit = {
    val min = if(st.isEmpty) x else {
      if(st.head._2 > x) x else st.head._2
    }
    st.push((x, min))
  }

  def pop(): Unit = {
    st.pop._1
  }

  def top(): Int = {
    st.head._1
  }

  def getMin(): Int = {
    st.head._2
  }

}

/**
  * Your MinStack object will be instantiated and called as such:
  * var obj = new MinStack()
  * obj.push(x)
  * obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.getMin()
  */
