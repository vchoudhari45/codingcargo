package com.vc.easy

class ListNode876(var _x: Int = 0) {
  var next: ListNode876 = null
  var x: Int = _x
}

object L876 {
  def middleNode(head: ListNode876): ListNode876 = {
    var fast = head
    var slow = head
    while(fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }
}
