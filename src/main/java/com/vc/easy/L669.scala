package com.vc.easy

class TreeNode669(var _value: Int) {
  var value: Int = _value
  var left: TreeNode669 = null
  var right: TreeNode669 = null
}

object L669 {
  def trimBST(root: TreeNode669, L: Int, R: Int): TreeNode669 = {
    if(root == null) root
    else if(root.value < L) trimBST(root.right, L, R)
    else if(root.value > R) trimBST(root.left, L, R)
    else {
      root.left = trimBST(root.left, L, R)
      root.right = trimBST(root.right, L, R)
      root
    }
  }
}
