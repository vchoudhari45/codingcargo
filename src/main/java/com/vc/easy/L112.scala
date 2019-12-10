package com.vc.easy

class TreeNode112(var _value: Int) {
  var value: Int = _value
  var left: TreeNode112 = null
  var right: TreeNode112 = null
}

object L112 {
  def hasPathSum(root: TreeNode112, sum: Int): Boolean = {
    if(root == null) return false
    else if(root.left == null && root.right == null) return root.value == sum
    else hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
  }
}
