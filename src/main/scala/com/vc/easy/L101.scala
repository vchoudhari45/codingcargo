package com.vc.easy

class TreeNode101(var _value: Int) {
  var value: Int = _value
  var left: TreeNode101 = null
  var right: TreeNode101 = null
}

object L101 {
  def isSymmetric(root: TreeNode101): Boolean = {
    if(root == null) true
    else isSameTree(root.left, root.right)
  }

  def isSameTree(r1: TreeNode101, r2: TreeNode101): Boolean = {
    if(r1 != null && r2 != null) {
      r1.value == r2.value && isSameTree(r1.left, r2.right) && isSameTree(r1.right, r2.left)
    }
    else if(r1 == null && r2 == null) true
    else false
  }
}
