package com.vc.easy

class ListNode234(var _x: Int = 0) {
  var next: ListNode234 = null
  var x: Int = _x
  override def toString: String = s"$x -> ${if(next != null) next.x else null}"
}

object L234 {
  def isPalindrome(head: ListNode234): Boolean = {
    var hare = head
    var tortoise = head

    while(hare != null && hare.next != null) {
      hare = hare.next
      hare = hare.next
      tortoise = tortoise.next
    }

    if(hare != null) tortoise = tortoise.next
    tortoise = reverse(tortoise)
    hare = head
    while(tortoise != null) {
      if(hare.x != tortoise.x) return false
      tortoise = tortoise.next
      hare = hare.next
    }
    true
  }

  def reverse(tortoise: ListNode234): ListNode234 = {
    var current = tortoise
    var prev: ListNode234 = null

    while(current != null) {
      val next = current.next
      current.next = prev
      prev = current
      current = next
    }
    prev
  }
}
