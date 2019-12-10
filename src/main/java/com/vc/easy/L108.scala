package com.vc.easy


class TreeNode108(var _value: Int) {
  var value: Int = _value
  var left: TreeNode108 = null
  var right: TreeNode108 = null
}

object L108 {
  def sortedArrayToBST(nums: Array[Int]): TreeNode108 = {
    def solve(lo: Int, hi: Int): TreeNode108 = {
      if(lo > hi) null
      else {
        val mid = lo + (hi - lo) / 2
        val tree = new TreeNode108(nums(mid))
        tree.left = solve(lo, mid - 1)
        tree.right = solve(mid + 1, hi)
        tree
      }
    }
    solve(0, nums.length - 1)
  }
}
