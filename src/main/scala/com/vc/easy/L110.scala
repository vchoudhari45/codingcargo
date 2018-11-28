package com.vc.easy


class TreeNode110(var _value: Int) {
  var value: Int = _value
  var left: TreeNode110 = null
  var right: TreeNode110 = null
}

object L110 {
  def isBalanced(root: TreeNode110): Boolean = {
    if(root == null) return true
    val l = height(root.left)
    val r = height(root.right)
    Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right)
  }

  def height(root: TreeNode110): Int = {
    if(root != null) return 1 + Math.max(height(root.left), height(root.right))
    0
  }
}
