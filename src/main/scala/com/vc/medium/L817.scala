package com.vc.medium


class ListNode817(var _x: Int = 0) {
  var next: ListNode817 = null
  var x: Int = _x
}

object L817 {
  def numComponents(head: ListNode817, arr: Array[Int]): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[Int]()
    arr.foreach(x => set += x)
    var current = head
    var res = 0
    while(current != null) {
      if(set.contains(current.x) && (current.next == null || !set.contains(current.next.x))) res += 1
      current = current.next
    }
    res
  }
}
