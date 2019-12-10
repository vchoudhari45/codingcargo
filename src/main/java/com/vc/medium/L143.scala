package com.vc.medium

class ListNode143(var _x: Int = 0) {
  var next: ListNode143 = null
  var x: Int = _x
}

object L143 {
  def reorderList(head: ListNode143): Unit = {
    if(head == null || head.next == null) return

    var hare = head
    var tortoise = head
    var prev = head
    while(hare != null && hare.next != null) {
      hare = hare.next.next
      prev = tortoise
      tortoise = tortoise.next
    }
    if(hare != null) {
      prev = prev.next
      tortoise = tortoise.next
    }

    prev.next = null
    hare = head
    tortoise = reverse(tortoise)
    val dummyNode = new ListNode143()
    var res = dummyNode
    while(hare != null || tortoise != null) {
      if(hare != null) {
        res.next = hare
        res = res.next
        hare = hare.next
      }
      if(tortoise != null) {
        res.next = tortoise
        res = res.next
        tortoise = tortoise.next
      }
    }
  }

  def reverse(head: ListNode143): ListNode143 = {
    val dummyNode = new ListNode143()
    dummyNode.next = head
    val prev = dummyNode
    val current = prev.next
    var next = current.next
    while(next != null) {
      current.next = next.next
      next.next = prev.next
      prev.next = next
      next = current.next
    }
    dummyNode.next
  }
}
