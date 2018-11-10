package com.vc.easy

class TreeNode226(var _value: Int) {
  var value: Int = _value
  var left: TreeNode226 = null
  var right: TreeNode226 = null
}

object L226 {
  def invertTree(root: TreeNode226): TreeNode226 = {
//    if(root != null) {
//      val tmp = root.right
//      root.right = invertTree(root.left)
//      root.left = invertTree(tmp)
//    }
//    root

    if(root == null) return root

    import scala.collection.mutable
    val q = new mutable.Queue[TreeNode226]()
    q.enqueue(root)
    while(q.nonEmpty) {
      val e = q.dequeue()
      val left = e.left
      e.left = e.right
      e.right = left
      if(e.left != null) q.enqueue(e.left)
      if(e.right != null) q.enqueue(e.right)
    }
    root
  }
}