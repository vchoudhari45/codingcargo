package com.vc.easy


class TreeNode897(var _value: Int) {
  var value: Int = _value
  var left: TreeNode897 = null
  var right: TreeNode897 = null
}

object L897 {
  def increasingBST(root: TreeNode897): TreeNode897 = {
    var prev: TreeNode897 = null
    var head: TreeNode897 = null
    def solve(root:TreeNode897) : Unit = {
      if(root != null) {
        solve(root.left)
        if(prev != null) {
          prev.right = root
          root.left = null
        }
        prev = root
        if(head == null) head = root
        solve(root.right)
      }
    }
    solve(root)
    head
  }
}