package com.vc.easy

class ListNode21(var _x: Int = 0) {
  var next: ListNode21 = null
  var x: Int = _x
}


object L21 {
  def mergeTwoLists(l1Param: ListNode21, l2Param: ListNode21): ListNode21 = {
    var l1 = l1Param
    var l2 = l2Param
    val res = new ListNode21(-1)
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
