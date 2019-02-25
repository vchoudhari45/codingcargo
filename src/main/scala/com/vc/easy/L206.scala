package com.vc.easy

class ListNode206(var _x: Int = 0) {
  var next: ListNode206 = null
  var x: Int = _x
}

object L206 {
  def reverseList(head: ListNode206): ListNode206 = {
    if(head == null) return head
    else {
      val dummyNode = new ListNode206()
      dummyNode.next = head

      val prev = dummyNode
      val current = prev.next
      var next = current.next

      //0->1->2->3->4->5->NULL
      //p->c->n->3->4->5->NULL

      //0->2->1->3->4->5->NULL
      //0->3->2->1->4->5->NULL
      //0->4->3->2->1->5->NULL
      //0->5->4->3->2->1->NULL
      while(next != null) {
        current.next = next.next
        next.next = prev.next
        prev.next = next
        next = current.next
      }
      dummyNode.next
    }
  }
}
