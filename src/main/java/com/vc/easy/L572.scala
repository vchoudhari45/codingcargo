package com.vc.easy

class TreeNode572(var _value: Int) {
  var value: Int = _value
  var left: TreeNode572 = null
  var right: TreeNode572 = null
}

object L572 {
  def isSubtree(s: TreeNode572, t: TreeNode572): Boolean = {
    if(s == null && t == null) true
    else if(s != null && t != null) {
      isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
    }
    else false
  }

  def isSameTree(s: TreeNode572, t: TreeNode572): Boolean = {
    if(s != null && t != null) s.value == t.value && isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    else if(s == null && t == null) true
    else false
  }
}
