package com.vc.easy


class TreeNode404(var _value: Int) {
  var value: Int = _value
  var left: TreeNode404 = null
  var right: TreeNode404 = null
}

object L404 {
  def sumOfLeftLeaves(root: TreeNode404): Int = {
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode404]()
    var current = root
    var res = 0
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.left
        if(current != null && current.right == null && current.left == null) res += current.value
      }
      else {
        current = st.pop.right
      }
    }
    res
  }
}
