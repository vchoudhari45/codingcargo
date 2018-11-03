package com.vc

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object L700 {
  def searchBST(root: TreeNode, value: Int): TreeNode = {
    var current = root
    while(current != null) {
      if(current.value < value) {
        current = current.right
      }
      else if(current.value > value) {
        current = current.left
      }
      else return current
    }
    current
  }
}
