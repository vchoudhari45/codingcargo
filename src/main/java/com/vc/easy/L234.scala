package com.vc.easy

class ListNode234(var _x: Int = 0) {
  var next: ListNode234 = null
  var x: Int = _x
  override def toString: String = s"$x -> ${if(next != null) next.x else null}"
}

object L234 {
  def isPalindrome(head: ListNode234): Boolean = {
    if(head == null || head.next == null) return true
    else {
      //Find Middle of the List
      var i = 0
      var current = head
      while(current != null) {
        current = current.next
        i += 1
      }
      val (j, even) = if(i % 2 == 0) (i / 2, true) else ((i - 1) / 2, false)

      //reverse first half of the list
      val (firstHalfReversed, secondHalf) = reverse(head, 0, j, even)

      //Validate the reversed first half with the second half
      current = firstHalfReversed
      var mid = secondHalf
      while(mid != null) {
        if(current.x != mid.x) return false
        current = current.next
        mid = mid.next
      }
      true
    }
  }

  def reverse(head:ListNode234, start: Int, end: Int, even: Boolean): (ListNode234, ListNode234) = {
    val dummyNode=  new ListNode234()
    dummyNode.next = head
    val prev = dummyNode
    val current = prev.next
    var next = current.next
    var s = start
    while(s < end - 1) {
      current.next = next.next
      next.next = prev.next
      prev.next = next
      next = current.next
      s += 1
    }
    if(even) (dummyNode.next, next)
    else (dummyNode.next, next.next)
  }
}
