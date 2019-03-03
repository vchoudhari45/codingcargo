package com.vc.hard

class ListNode25(var _x: Int = 0) {
 var next: ListNode25 = null
 var x: Int = _x
}

object L25 {
  def reverseKGroup(head: ListNode25, k: Int): ListNode25 = {
    if(head == null || head.next == null) return head

    var n = 0
    var current = head
    while(current != null) {
      n += 1
      current = current.next
    }

    if(k > n) return head

    val dummyNode = new ListNode25()
    dummyNode.next = head
    var prev = dummyNode
    current = prev.next
    var next = current.next

    var i = 0
    while(next != null) {
      i += 1
      if(n < k) return dummyNode.next
      if(i % k == 0) {
         n -= k
         prev = current
         current = current.next
         next = current.next
      }
      else {
        current.next = next.next
        next.next = prev.next
        prev.next = next
        next = current.next
      }
    }
    dummyNode.next
  }
}
