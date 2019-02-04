package com.vc.medium

class TreeNode106(var _value: Int) {
  var value: Int = _value
  var left: TreeNode106 = null
  var right: TreeNode106 = null
}

object L106 {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode106 = {
    def solve(iStart: Int, iEnd: Int, pRoot: Int): TreeNode106 = {
      if(pRoot < 0 || iStart > iEnd) return null
      val tree = new TreeNode106(postorder(pRoot))
      var iRoot = iStart
      while(inorder(iRoot) != postorder(pRoot)) iRoot += 1
      tree.left = solve(iStart, iRoot - 1, pRoot - 1 - iEnd + iRoot)
      tree.right = solve(iRoot + 1, iEnd, pRoot - 1)
      tree
    }
    solve(0, inorder.length - 1, inorder.length - 1)
  }
}