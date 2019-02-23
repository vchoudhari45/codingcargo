package com.vc.medium


class ListNode19(var _x: Int = 0) {
  var next: ListNode19 = null
  var x: Int = _x
}

object L19 {
  def removeNthFromEnd(head: ListNode19, n: Int): ListNode19 = {
    val dummyNode = new ListNode19()
    dummyNode.next = head
    var hare = dummyNode
    var tortoize = dummyNode

    (0 to n).foreach(_ => hare = hare.next)
    while(hare != null) {
      hare = hare.next
      tortoize = tortoize.next
    }
    tortoize.next = tortoize.next.next
    dummyNode.next
  }
}