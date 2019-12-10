package com.vc.medium


class TreeNode230(var _value: Int) {
  var value: Int = _value
  var left: TreeNode230 = null
  var right: TreeNode230 = null
}

object L230 {
  def kthSmallest(root: TreeNode230, k: Int): Int = {
    var count = k
    var res = 0
    def solve(root: TreeNode230): Unit = {
      if(root.left != null) solve(root.left)
      count -= 1
      if(count == 0) {
        res = root.value
        return
      }
      if(root.right != null) solve(root.right)
    }
    solve(root)
    res
  }
}
