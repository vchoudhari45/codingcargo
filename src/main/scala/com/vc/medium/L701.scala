package com.vc.medium

class TreeNode701(var _value: Int) {
  var value: Int = _value
  var left: TreeNode701 = null
  var right: TreeNode701 = null
}

object Solution {
  def insertIntoBST(root: TreeNode701, value: Int): TreeNode701 = {
    var current = root
    var prev = current
    while(current != null) {
      prev = current
      if(current.value > value)
        current = current.left
      else
        current = current.right
    }

    if(prev.value > value) prev.left = new TreeNode701(value)
    else prev.right = new TreeNode701(value)

    root
  }
}
