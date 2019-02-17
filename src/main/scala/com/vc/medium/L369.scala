package com.vc.medium

class ListNodeL369(var _x: Int = 0) {
  var next: ListNodeL369 = null
  var x: Int = _x
}

object Solution {
  def plusOne(head: ListNodeL369): ListNodeL369 = {
    var current = reverse(head)

    var add = 1
    var carry = 0
    var list = current
    while(list != null && carry + add > 0) {
      list.x += carry + add
      carry = 0
      if(list.x > 9) {
        carry = list.x / 10
        list.x = list.x % 10
      }
      if(add > 0) add -= 1
      list = list.next
    }

    current = reverse(current)
    if(carry > 0) {
      val res = new ListNodeL369(carry)
      res.next = current
      res
    }
    else current
  }

  def reverse(head: ListNodeL369): ListNodeL369 = {
    var current = head
    var prev: ListNodeL369 = null
    var next: ListNodeL369 = null
    while(current != null) {
      next = current.next
      current.next = prev
      prev = current
      current = next
    }
    prev
  }
}
