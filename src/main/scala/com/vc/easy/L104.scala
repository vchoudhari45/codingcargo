package com.vc.easy

class TreeNode104(var _value: Int) {
  var value: Int = _value
  var left: TreeNode104 = null
  var right: TreeNode104 = null
}

object Solution {
  def maxDepth(root: TreeNode104): Int = {
    if(root == null) return 0
    1 + Math.max(maxDepth(root.left), maxDepth(root.right))
  }
}
