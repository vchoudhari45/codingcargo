package com.vc.easy

class TreeNode653(var _value: Int) {
  var value: Int = _value
  var left: TreeNode653 = null
  var right: TreeNode653 = null
}

object L653 {
  def findTarget(root: TreeNode653, k: Int): Boolean = {
    if(root == null) return false
    import scala.collection.mutable
    val set = new mutable.HashSet[Int]()
    val st = new mutable.Stack[TreeNode653]()
    st.push(root)
    while(st.nonEmpty) {
      val e = st.pop
      if(set.contains(k - e.value)) return true
      set += e.value
      if(e.right != null) st.push(e.right)
      if(e.left != null) st.push(e.left)
    }
    false
  }
}