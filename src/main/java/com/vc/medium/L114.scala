package com.vc.medium

class TreeNode114(var _value: Int) {
  var value: Int = _value
  var left: TreeNode114 = null
  var right: TreeNode114 = null
}

object L114 {
  def flatten(root: TreeNode114): Unit = {
    var prev: TreeNode114 = null
    def solve(root: TreeNode114): Unit = {
      if(root != null) {
        solve(root.right)
        solve(root.left)
        root.right = prev
        root.left = null
        prev = root
      }
    }
    solve(root)
    prev
  }
}
