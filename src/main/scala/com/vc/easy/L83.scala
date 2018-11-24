package com.vc.easy

class ListNode83(var _x: Int = 0) {
  var next: ListNode83 = null
  var x: Int = _x
}

object L83 {
  def deleteDuplicates(head: ListNode83): ListNode83 = {
    var current = head
    while(current != null) {
      if(current.next != null) {
        if(current.x == current.next.x) {
          current.next = current.next.next
        }
        else current = current.next
      }
      else current = current.next
    }
    head
  }
}
