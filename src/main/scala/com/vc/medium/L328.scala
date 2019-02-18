package com.vc.medium


class ListNodeL328(var _x: Int = 0) {
  var next: ListNodeL328 = null
  var x: Int = _x
}

object L328 {
  def oddEvenList(head: ListNodeL328): ListNodeL328 = {
    if(head == null) return head
    var odd = head
    var even = head.next
    val evenHead = even
    while(even != null && even.next != null) {
      odd.next = odd.next.next
      even.next = even.next.next
      odd = odd.next
      even = even.next
    }
    odd.next = evenHead
    head
  }
}
