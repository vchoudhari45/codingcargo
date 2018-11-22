package com.vc.easy

class TreeNode543(var _value: Int) {
  var value: Int = _value
  var left: TreeNode543 = null
  var right: TreeNode543 = null
}

object L543 {
  def diameterOfBinaryTree(root: TreeNode543): Int = {
    var diameter = 0
    def height(root:TreeNode543): Int = {
      if(root != null) {
        val l = height(root.left)
        val r = height(root.right)
        diameter = Math.max(diameter, l + r)
        return 1 + Math.max(l, r)
      }
      0
    }
    height(root)
    diameter
  }
}
