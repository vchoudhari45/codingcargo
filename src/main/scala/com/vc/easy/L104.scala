package com.vc.easy

class TreeNode104(var _value: Int) {
  var value: Int = _value
  var left: TreeNode104 = null
  var right: TreeNode104 = null
}

object Solution {
  def maxDepth(root: TreeNode104): Int = {
    /**
      * if(root == null) return 0
      * 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
      **/
    if(root == null) return 0
    import scala.collection.mutable
    val q = new mutable.Queue[TreeNode104]()
    q.enqueue(root)
    var res = 0
    while(q.nonEmpty) {
      var size = q.size
      while(size != 0) {
        val e = q.dequeue()
        if(e.left != null) q.enqueue(e.left)
        if(e.right != null) q.enqueue(e.right)
        size -= 1
      }
      res += 1
    }
    res
  }
}
