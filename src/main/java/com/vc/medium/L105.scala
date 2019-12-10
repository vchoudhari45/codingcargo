package com.vc.medium

class TreeNode105(var _value: Int) {
  var value: Int = _value
  var left: TreeNode105 = null
  var right: TreeNode105 = null
}

object L105 {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode105 = {
    def solve(iStart: Int, iEnd: Int, preRoot: Int): TreeNode105 = {
      if(preRoot >= preorder.length || iStart > iEnd) return null
      val root = new TreeNode105(preorder(preRoot))
      var inRoot = iStart
      while(inorder(inRoot) != preorder(preRoot)) inRoot += 1
      root.left = solve(iStart, inRoot - 1, preRoot + 1)
      root.right = solve(inRoot + 1, iEnd,  preRoot + 1 + inRoot - iStart)
      root
    }
    solve(0, inorder.length - 1, 0)
  }
}