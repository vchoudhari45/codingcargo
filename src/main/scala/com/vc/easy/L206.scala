package com.vc.easy

class ListNode206(var _x: Int = 0) {
  var next: ListNode206 = null
  var x: Int = _x
}

object L206 {
  def reverseList(head: ListNode206): ListNode206 = {
    if(head == null || head.next == null) head
    else {
      var prev:ListNode206 = null
      var current = head
      var next:ListNode206 = null
      while(current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
      }
      prev
    }
  }
}
