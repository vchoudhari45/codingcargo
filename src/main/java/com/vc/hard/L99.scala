package com.vc.hard

class TreeNode99(var _value: Int) {
  var value: Int = _value
  var left: TreeNode99 = null
  var right: TreeNode99 = null
}

object L99 {
  def recoverTree(root: TreeNode99): Unit = {
    var x: TreeNode99 = null
    var y: TreeNode99 = null
    def swap(x: TreeNode99, y: TreeNode99): Unit = {
      if(x != y) {
        x.value ^= y.value
        y.value ^= x.value
        x.value ^= y.value
      }
    }
    var prev: TreeNode99 = null
    def solve(root: TreeNode99): Unit = {
      if(root != null) {
        solve(root.left)
        if(prev != null && prev.value > root.value) {
          y = root
          if(x == null) x = prev
        }
        prev = root
        solve(root.right)
      }
    }
    solve(root)
    swap(x, y)
  }
}