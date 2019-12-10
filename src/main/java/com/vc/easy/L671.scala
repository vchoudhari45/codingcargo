package com.vc.easy


class TreeNode671(var _value: Int) {
  var value: Int = _value
  var left: TreeNode671 = null
  var right: TreeNode671 = null
}

object L671 {
  def findSecondMinimumValue(root: TreeNode671): Int = {
    var min = Int.MaxValue
    var res = Int.MaxValue
    def solve(root: TreeNode671): Unit = {
      if(root != null) {
        if(root.value < min) {
          res = min
          min = root.value
        }
        else if(root.value < res && root.value != min) {
          res = root.value
        }
        solve(root.left)
        solve(root.right)
      }
    }
    solve(root)
    if(res == Int.MaxValue) -1 else res
  }
}
