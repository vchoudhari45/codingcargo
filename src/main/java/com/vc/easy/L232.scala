package com.vc.easy

import scala.collection.mutable

class MyQueue() {

  /** Initialize your data structure here. */
  val st = new mutable.Stack[Int]()

  /** Push element x to the back of queue. */
  def push(x: Int): Unit = {
    val stNew = new mutable.Stack[Int]()
    while(st.nonEmpty) {
      stNew.push(st.pop)
    }
    st.push(x)
    while(stNew.nonEmpty) {
      st.push(stNew.pop)
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = st.pop

  /** Get the front element. */
  def peek(): Int = st.head

  /** Returns whether the queue is empty. */
  def empty(): Boolean = st.isEmpty

}

/**
  * Your MyQueue object will be instantiated and called as such:
  * var obj = new MyQueue()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.peek()
  * var param_4 = obj.empty()
  */
