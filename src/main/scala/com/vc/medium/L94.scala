package com.vc.medium


class TreeNode94(var _value: Int) {
  var value: Int = _value
  var left: TreeNode94 = null
  var right: TreeNode94 = null
}

object Solution {
  def inorderTraversal(root: TreeNode94): List[Int] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    val st = new mutable.Stack[TreeNode94]()
    var current = root
    while(st.nonEmpty || current != null) {
      if(current != null) {
        st.push(current)
        current = current.left
      }
      else {
        current = st.pop
        list += current.value
        current = current.right
      }
    }
    list.toList
  }
}
