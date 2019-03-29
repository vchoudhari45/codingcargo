package com.vc.medium

class TreeNode776(var _value: Int) {
  var value: Int = _value
  var left: TreeNode776 = null
  var right: TreeNode776 = null
}

object L776 {
  def splitBST(root: TreeNode776, V: Int): Array[TreeNode776] = {
    if(root == null) return Array(null, null)
    if(root.value <= V) {
      val binarySplit = splitBST(root.right, V)
      root.right = binarySplit(0)
      binarySplit(0) = root
      binarySplit
    }
    else {
      val binarySplit = splitBST(root.left, V)
      root.left = binarySplit(1)
      binarySplit(1) = root
      binarySplit
    }
  }
}
