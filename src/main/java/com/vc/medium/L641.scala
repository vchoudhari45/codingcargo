package com.vc.medium

case class DoublyLinkedList(var prev: DoublyLinkedList, var next: DoublyLinkedList, value: Int)
class MyCircularDeque(k: Int) {

  /** Initialize your data structure here. Set the size of the deque to be k. */
  val head = new DoublyLinkedList(null, null, -1)
  val tail = new DoublyLinkedList(head, null, -1)
  head.next = tail
  var size = 0

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  def insertFront(value: Int): Boolean = {
    if(size < k) {
      val headNext = head.next
      val e = DoublyLinkedList(head, headNext, value)
      headNext.prev = e
      head.next = e
      size += 1
      return true
    }
    false
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  def insertLast(value: Int): Boolean = {
    if(size < k) {
      val tailPrev = tail.prev
      val e = DoublyLinkedList(tailPrev, tail, value)
      tailPrev.next = e
      tail.prev = e
      size += 1
      return true
    }
    false
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  def deleteFront(): Boolean = {
    if(size > 0) {
      head.next = head.next.next
      head.next.prev = head
      size -= 1
      return true
    }
    return false
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  def deleteLast(): Boolean = {
    if(size > 0) {
      tail.prev = tail.prev.prev
      tail.prev.next = tail
      size -= 1
      return true
    }
    return false
  }

  /** Get the front item from the deque. */
  def getFront(): Int = head.next.value

  /** Get the last item from the deque. */
  def getRear(): Int = tail.prev.value

  /** Checks whether the circular deque is empty or not. */
  def isEmpty(): Boolean = size == 0

  /** Checks whether the circular deque is full or not. */
  def isFull(): Boolean = size == k

}

/**
  * Your MyCircularDeque object will be instantiated and called as such:
  * var obj = new MyCircularDeque(k)
  * var param_1 = obj.insertFront(value)
  * var param_2 = obj.insertLast(value)
  * var param_3 = obj.deleteFront()
  * var param_4 = obj.deleteLast()
  * var param_5 = obj.getFront()
  * var param_6 = obj.getRear()
  * var param_7 = obj.isEmpty()
  * var param_8 = obj.isFull()
  */
