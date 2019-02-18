package com.vc.medium


class ListNode382(var _x: Int = 0) {
  var next: ListNode382 = null
  var x: Int = _x
}

class L382(head: ListNode382) {

  /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
  val random = new scala.util.Random()

  /** Returns a random node's value. */
  def getRandom(): Int = {
    var current = head
    var r = current.x
    current = current.next
    var i = 1
    while(current != null) {
      if(i == random.nextInt(i + 1)) r = current.x
      current = current.next
      i += 1
    }
    r
  }

}