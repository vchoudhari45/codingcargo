package com.vc.medium

class TreeNode919(var _value: Int) {
  var value: Int = _value
  var left: TreeNode919 = null
  var right: TreeNode919 = null
}

class CBTInserter(root: TreeNode919) {

  import scala.collection.mutable

  def insert(v: Int): Int = {
    val q = new mutable.Queue[TreeNode919]()
    q.enqueue(root)
    while(true) {
      val e = q.dequeue()
      if(e.left != null && e.right != null) {
        q.enqueue(e.left)
        q.enqueue(e.right)
      }
      else if(e.left == null) {
        e.left = new TreeNode919(v)
        return e.value
      }
      else {
        e.right = new TreeNode919(v)
        return e.value
      }
    }
    -1
  }

  def get_root(): TreeNode919 = root

}

/**
  * Your CBTInserter object will be instantiated and called as such:
  * var obj = new CBTInserter(root)
  * var param_1 = obj.insert(v)
  * var param_2 = obj.get_root()
  */
