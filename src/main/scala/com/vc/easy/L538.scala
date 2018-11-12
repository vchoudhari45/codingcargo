package com.vc.easy

class TreeNode538(var _value: Int) {
  var value: Int = _value
  var left: TreeNode538 = null
  var right: TreeNode538 = null
}

object Solution {
  def convertBST(root: TreeNode538): TreeNode538 = {
    /**
    var sum = 0
    solve(root)
    def solve(root: TreeNode538): Unit = {
      if(root != null) {
        solve(root.right)
        val right = root.value
        root.value += sum
        sum += right
        solve(root.left)
      }
    }
    root*/
    var sum = 0
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode538]()
    var current = root
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.right
      }
      else {
        current = st.pop
        val oldValue = current.value
        current.value += sum
        sum += oldValue
        current = current.left
      }
    }
    root
  }
}