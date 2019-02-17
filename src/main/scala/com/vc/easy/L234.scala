package com.vc.easy

class ListNode234(var _x: Int = 0) {
  var next: ListNode234 = null
  var x: Int = _x
  override def toString: String = s"$x -> ${if(next != null) next.x else null}"
}

object L234 {
  def isPalindrome(head: ListNode234): Boolean = {
    var i = 0
    var current = head
    while(current != null) {
      current = current.next
      i += 1
    }

    var mid = head
    var j = if(i % 2 == 0) i / 2 else i / 2 + 1
    while(j > 0) {
      mid = mid.next
      j -= 1
    }

    current = reverse(head, i / 2)
    while(mid != null) {
      if(mid.x != current.x) return false
      mid = mid.next
      current = current.next
    }
    true
  }

  def reverse(head: ListNode234, count: Int): ListNode234 = {
    var current = head
    var prev: ListNode234 = null
    var next: ListNode234 = null
    var c = count
    while(c > 0) {
      next = current.next
      current.next = prev
      prev = current
      current = next
      c -= 1
    }
    prev
  }
}
