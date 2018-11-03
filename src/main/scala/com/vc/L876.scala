package com.vc

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object L876 {
  def middleNode(head: ListNode): ListNode = {
    var fast = head
    var slow = head
    while(fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }
}
