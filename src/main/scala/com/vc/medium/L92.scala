package com.vc.medium


class ListNode92(var _x: Int = 0) {
  var next: ListNode92 = null
  var x: Int = _x
}

object L92 {
  def reverseBetween(head: ListNode92, m: Int, n: Int): ListNode92 = {
    if(head == null) head
    else {
      val dummyNode = new ListNode92()
      dummyNode.next = head

      var prev = dummyNode
      var i = 1
      while(i < m) {
        prev = prev.next
        i += 1
      }

      val current = prev.next
      var next = current.next

      //1->2->3->4->5->NULL
      //p->c->n->4->5->NULL
      while(i < n) {
        current.next = next.next
        next.next = prev.next
        prev.next = next
        next = current.next
        i += 1
      }
      dummyNode.next
    }
  }
}
