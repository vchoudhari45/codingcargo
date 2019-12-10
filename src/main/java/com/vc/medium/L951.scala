package com.vc.medium

class TreeNode951(var _value: Int) {
  var value: Int = _value
  var left: TreeNode951 = null
  var right: TreeNode951 = null
}

object L951 {
  def flipEquiv(root1: TreeNode951, root2: TreeNode951): Boolean = {
    if(root1 == null || root2 == null) return root1 == root2
    else if(root1.value != root2.value) return false
    else (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
  }
}
