package com.vc.easy

class L225() {

  /** Initialize your data structure here. */
  import scala.collection.mutable
  val q = new mutable.Queue[Int]()

  /** Push element x onto stack. */
  def push(x: Int): Unit = {
    val t = new mutable.Queue[Int]()
    while(q.nonEmpty) {
      t.enqueue(q.dequeue)
    }
    q.enqueue(x)
    while(t.nonEmpty) {
      q.enqueue(t.dequeue)
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = q.dequeue()

  /** Get the top element. */
  def top(): Int = q.head

  /** Returns whether the stack is empty. */
  def empty(): Boolean = q.isEmpty

}

/**
  * Your MyStack object will be instantiated and called as such:
  * var obj = new MyStack()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.empty()
  */
