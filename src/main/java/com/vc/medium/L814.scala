package com.vc.medium


class TreeNode814(var _value: Int) {
  var value: Int = _value
  var left: TreeNode814 = null
  var right: TreeNode814 = null
}

object L814 {
  def pruneTree(root: TreeNode814): TreeNode814 = {
    if(containsOne(root)) return root
    else null
  }

  def containsOne(root: TreeNode814): Boolean = {
    if(root != null) {
      val l = containsOne(root.left)
      val r = containsOne(root.right)
      if(!l) root.left = null
      if(!r) root.right = null
      return root.value == 1 || l || r
    }
    false
  }
}
