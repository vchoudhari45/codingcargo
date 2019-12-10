package com.vc.easy

class ListNode203(var _x: Int = 0) {
  var next: ListNode203 = null
  var x: Int = _x
}

object L203 {
  def removeElements(head: ListNode203, value: Int): ListNode203 = {
    val dummy = new ListNode203()
    dummy.next = head

    var prev = dummy
    var current = head
    prev.next = current
    while(current != null) {
      if(current.x == value) {
        prev.next = current.next
        current = current.next
      }
      else {
        prev = current
        current = current.next
      }
    }
    dummy.next
  }
}
