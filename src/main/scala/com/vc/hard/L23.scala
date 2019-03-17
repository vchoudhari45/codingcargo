package com.vc.hard

class ListNode23(var _x: Int = 0) {
  var next: ListNode23 = null
  var x: Int = _x
}


object PQOrdering extends Ordering[ListNode23] {
  def compare(l1: ListNode23, l2: ListNode23): Int = {
    if(l1 == null) 1
    else if(l2 == null) -1
    else l2.x.compareTo(l1.x)
  }
}
object L23 {
  def mergeKLists(lists: Array[ListNode23]): ListNode23 = {
    import scala.collection.mutable
    val pq = new mutable.PriorityQueue[ListNode23]()(PQOrdering)
    lists.foreach(list => pq.enqueue(list))

    val dummyNode = new ListNode23()
    var res = dummyNode
    while(pq.nonEmpty) {
      val e = pq.dequeue()
      if(e != null) {
        res.next = e
        res = res.next
        pq.enqueue(e.next)
      }
    }
    dummyNode.next
  }
}
