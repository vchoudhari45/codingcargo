package com.vc.medium

class ListNode109(var _x: Int = 0) {
  var next: ListNode109 = null
  var x: Int = _x
}

class TreeNode109(var _value: Int) {
  var value: Int = _value
  var left: TreeNode109 = null
  var right: TreeNode109 = null
}

object Solution {
  def sortedListToBST(head: ListNode109): TreeNode109 = {
    def solve(head: ListNode109, tail: ListNode109): TreeNode109 = {
      if(head == tail) return null
      var hare = head
      var tortoize = head
      while(hare != tail && hare.next != tail) {
        hare = hare.next
        hare = hare.next
        tortoize = tortoize.next
      }
      val root = new TreeNode109(tortoize.x)
      root.left = solve(head, tortoize)
      root.right = solve(tortoize.next, tail)
      root
    }
    if(head == null) return null
    else solve(head, null)
  }
}
