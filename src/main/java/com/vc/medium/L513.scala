package com.vc.medium

class TreeNode513(var _value: Int) {
  var value: Int = _value
  var left: TreeNode513 = null
  var right: TreeNode513 = null
}

object L513 {
  def findBottomLeftValue(root: TreeNode513): Int = {
    import scala.collection.mutable
    val q = new mutable.Queue[TreeNode513]()
    var res = root.value
    q.enqueue(root)
    while(q.nonEmpty) {
      val e = q.dequeue
      if(e.right != null) {
        res = e.right.value
        q.enqueue(e.right)
      }
      if(e.left != null) {
        res = e.left.value
        q.enqueue(e.left)
      }
    }
    res
  }
}
