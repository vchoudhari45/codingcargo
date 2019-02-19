package com.vc.medium


class ListNode24(var _x: Int = 0) {
  var next: ListNode24 = null
  var x: Int = _x
}

object L24 {
  def swapPairs(head: ListNode24): ListNode24 = {
    if(head == null || head.next == null) return head

    val dummyNode = new ListNode24()
    var prev = head
    dummyNode.next = head.next

    //Idea is to process 4 at a time not two at a time
    while(true) {
      val current = prev.next
      val next = current.next
      current.next = prev
      if(next == null || next.next == null) {
        prev.next = next
        return dummyNode.next
      }
      prev.next = next.next
      prev = next
    }
    dummyNode.next
  }
}