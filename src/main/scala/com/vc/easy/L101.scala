package com.vc.easy

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    if(root == null) true
    else isSameTree(root.left, root.right)
  }

  def isSameTree(r1: TreeNode, r2: TreeNode): Boolean = {
    if(r1 != null && r2 != null) {
      r1.value == r2.value && isSameTree(r1.left, r2.right) && isSameTree(r1.right, r2.left)
    }
    else if(r1 == null && r2 == null) true
    else false
  }
}
