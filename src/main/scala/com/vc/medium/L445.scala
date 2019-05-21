package com.vc.medium

class ListNode445(var _x: Int = 0) {
  var next: ListNode445 = null
  var x: Int = _x
}

object L445 {
  def addTwoNumbers(l1: ListNode445, l2: ListNode445): ListNode445 = {
    var l1Var = reverse(l1)
    var l2Var = reverse(l2)

    val res = l1Var
    var prev = l1Var
    var carry = 0
    while(l1Var != null || l2Var != null || carry != 0) {
      val v1 = if(l1Var != null) l1Var.x else 0
      val v2 = if(l2Var != null) l2Var.x else 0
      val total = v1 + v2 + carry
      if(l1Var == null) {
        l1Var = new ListNode445(total % 10)
        prev.next = l1Var
      }
      else l1Var.x = total % 10
      prev = l1Var
      carry = total / 10
      l1Var = if(l1Var != null) l1Var.next else l1Var
      l2Var = if(l2Var != null) l2Var.next else l2Var
    }
    reverse(res)
  }

  def reverse(head: ListNode445): ListNode445 = {
    val dummyNode = new ListNode445()
    val prev = dummyNode
    prev.next = head
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
