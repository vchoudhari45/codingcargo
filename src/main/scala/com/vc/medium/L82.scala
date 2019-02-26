package com.vc.medium


class ListNode82(var _x: Int = 0) {
 var next: ListNode82 = null
 var x: Int = _x
}

object L82 {
  def deleteDuplicates(head: ListNode82): ListNode82 = {
    if(head == null || head.next == null) return head

    val dummyNode = new ListNode82()
    dummyNode.next = head
    var prev = dummyNode
    var current = prev.next
    var next = current.next
    while(next != null ) {
      if(current.x == next.x) {
        val dup = current
        while(current != null && current.x == dup.x) {
          prev.next = next
          current = next
          next = if(next != null) next.next else null
        }
      }
      else {
        prev = current
        current = next
        next = next.next
      }
    }
    dummyNode.next
  }
}
