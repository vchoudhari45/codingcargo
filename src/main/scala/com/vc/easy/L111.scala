package com.vc.easy


class TreeNode111(var _value: Int) {
  var value: Int = _value
  var left: TreeNode111 = null
  var right: TreeNode111 = null
}

object L111 {
  def minDepth(root: TreeNode111): Int = {
    if(root == null) 0
    else if(root.left == null) 1 + minDepth(root.right)
    else if(root.right == null) 1 + minDepth(root.left)
    else 1 + Math.min(minDepth(root.left), minDepth(root.right))
  }
}
