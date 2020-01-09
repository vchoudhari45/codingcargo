package com.vc.medium

class TreeNodeL250(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL250 = null
  var right: TreeNodeL250 = null
}

object L250 {
  def countUnivalSubtrees(root: TreeNodeL250): Int = {
    var count = 0
    def solve(root: TreeNodeL250, value: Int): Boolean = {
      if(root == null) return true
      if(!solve(root.left, root.value) | !solve(root.right, root.value)) return false
      count += 1
      root.value == value
    }
    solve(root, 0)
    count
  }
}
