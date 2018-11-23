package com.vc.easy

object L21 {
  def mergeTwoLists(l1Param: ListNode, l2Param: ListNode): ListNode = {
    var l1 = l1Param
    var l2 = l2Param
    val res = new ListNode(-1)
    var prev = res
    while(l1 != null && l2 != null) {
      if(l1.x < l2.x) {
        prev.next = l1
        l1 = l1.next
        prev = prev.next
      }
      else {
        prev.next = l2
        l2 = l2.next
        prev = prev.next
      }
    }

    while(l1 != null) {
      prev.next = l1
      l1 = l1.next
      prev = prev.next
    }

    while(l2 != null) {
      prev.next = l2
      l2 = l2.next
      prev = prev.next
    }

    res.next
  }
}
