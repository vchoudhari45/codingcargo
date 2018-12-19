package com.vc.easy

class TreeNode687(var _value: Int) {
  var value: Int = _value
  var left: TreeNode687 = null
  var right: TreeNode687 = null
}

object L687 {
  def longestUnivaluePath(root: TreeNode687): Int = {
    var maxLength = 0
    def find(root: TreeNode687): Unit = {
      if(root != null) {
        val left = height(root.left, root.value)
        val right = height(root.right, root.value)
        maxLength = Math.max(maxLength, left + right)
        find(root.left)
        find(root.right)
      }
    }
    def height(root:TreeNode687, v:Int): Int = {
      if(root != null) {
        if(root.value == v) {
          return 1 + Math.max(height(root.left, v), height(root.right, v))
        }
      }
      0
    }
    find(root)
    maxLength
  }
}
