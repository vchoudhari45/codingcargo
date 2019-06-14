package com.vc.medium


class TreeNodeL958(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL958 = null
  var right: TreeNodeL958 = null
}

object Solution {
  def isCompleteTree(root: TreeNodeL958): Boolean = {
    import scala.collection.mutable
    val q = new mutable.Queue[TreeNodeL958]()
    q.enqueue(root)
    var end = false
    while(q.nonEmpty) {
      val e = q.dequeue()
      if(e == null) end = true
      else {
        if(end) return false
        q.enqueue(e.left)
        q.enqueue(e.right)
      }
    }
    true
  }
}