package com.vc.easy

class TreeNode563(var _value: Int) {
  var value: Int = _value
  var left: TreeNode563 = null
  var right: TreeNode563 = null
}

object L563 {
  def findTilt(root: TreeNode563): Int = {
    var sumTilt = 0
    def solve(root: TreeNode563): Int = {
      if(root != null) {
        val l = solve(root.left)
        val r =  solve(root.right)
        sumTilt += Math.abs(l - r)
        return l + r + root.value
      }
      0
    }
    solve(root)
    sumTilt
  }
}