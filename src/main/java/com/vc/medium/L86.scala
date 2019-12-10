package com.vc.medium

class ListNode86(var _x: Int = 0) {
  var next: ListNode86 = null
  var x: Int = _x
}

object L86 {
  def partition(head: ListNode86, x: Int): ListNode86 = {
    val d1 = new ListNode86()
    val d2 = new ListNode86()
    var lo = d1
    var hi = d2
    var current = head
    while(current != null) {
      if(current.x >= x) {
        hi.next = current
        hi = current
      }
      else {
        lo.next = current
        lo = current
      }
      current = current.next
    }
    hi.next = null
    lo.next = d2.next
    d1.next
  }
}
