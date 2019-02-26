package com.vc.medium

class ListNode148(var _x: Int = 0) {
  var next: ListNode148 = null
  var x: Int = _x
}

object L148 {
  def sortList(head: ListNode148): ListNode148 = {
    if(head == null || head.next == null) return head

    var prev = head
    var hare = head
    var tortoise = head
    while(hare != null && hare.next != null) {
      prev = tortoise
      tortoise = tortoise.next
      hare = hare.next.next
    }
    prev.next = null
    merge(sortList(head), sortList(tortoise))
  }

  def merge(list1: ListNode148, list2: ListNode148): ListNode148 = {
    val dummyNode = new ListNode148()

    var l = dummyNode
    var l1 = list1
    var l2 = list2
    while(l1 != null && l2 != null) {
      if(l1.x > l2.x) {
        l.next = l2
        l2 = l2.next
      }
      else {
        l.next = l1
        l1 = l1.next
      }
      l = l.next
    }
    if(l1 != null) l.next = l1
    else l.next = l2
    dummyNode.next
  }
}
