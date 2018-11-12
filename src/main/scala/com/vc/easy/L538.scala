package com.vc.easy

class TreeNode538(var _value: Int) {
  var value: Int = _value
  var left: TreeNode538 = null
  var right: TreeNode538 = null
}

object Solution {
  def convertBST(root: TreeNode538): TreeNode538 = {
    var sum = 0
    solve(root)
    def solve(root: TreeNode538): Unit = {
      if(root != null) {
        solve(root.right)
        val right = root.value
        root.value += sum
        sum += right
        solve(root.left)
      }
    }
    root
  }
}