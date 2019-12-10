package com.vc.medium

class ListNode61(var _x: Int = 0) {
  var next: ListNode61 = null
  var x: Int = _x
}

object L61 {
  def rotateRight(head: ListNode61, k: Int): ListNode61 = {
    if(head == null || head.next == null) return head

    var n = 0
    val dummyNode = new ListNode61()
    dummyNode.next = head
    var hare = dummyNode
    var tortoise = dummyNode
    while(hare.next != null) {
      n += 1
      hare = hare.next
    }

    var i = 0
    while(i < n - k % n) {
      tortoise = tortoise.next
      i += 1
    }

    hare.next = dummyNode.next
    dummyNode.next = tortoise.next
    tortoise.next = null
    dummyNode.next
  }
}
