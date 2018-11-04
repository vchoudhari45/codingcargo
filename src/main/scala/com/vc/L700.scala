package com.vc

class TreeNode700(var _value: Int) {
  var value: Int = _value
  var left: TreeNode700 = null
  var right: TreeNode700 = null
}

object L700 {
  def searchBST(root: TreeNode700, value: Int): TreeNode700 = {
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
