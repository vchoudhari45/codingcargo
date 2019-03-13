package com.vc.medium


class TreeNode865(var _value: Int) {
  var value: Int = _value
  var left: TreeNode865 = null
  var right: TreeNode865 = null
}

object L865 {
  def subtreeWithAllDeepest(root: TreeNode865): TreeNode865 = {
    var depth = 0
    var res: TreeNode865 = null
    def dfs(root: TreeNode865, level: Int): Int = {
      if(root == null) level
      else {
        val l = dfs(root.left, level + 1)
        val r = dfs(root.right, level + 1)
        val currentDepth = Math.max(l, r)
        if(currentDepth >= depth && l == r) {
          depth = currentDepth
          res = root
        }
        currentDepth
      }
    }
    dfs(root, 0)
    res
  }
}
