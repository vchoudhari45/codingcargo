package com.vc.medium

class TreeNodeL156(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL156 = null
  var right: TreeNodeL156 = null
}

object L156 {
  /**
    *       1
    *      / \
    *     2  3
    *    / \
    *   4  5
    *
    *       1
    *      /
    *     2---3
    *    /
    *   4---5
    **/

  def upsideDownBinaryTree(root: TreeNodeL156): TreeNodeL156 = {
    var current = root
    var prev: TreeNodeL156 = null
    var next: TreeNodeL156 = null
    var prevRight: TreeNodeL156 = null
    while(current != null) {
      next = current.left
      current.left = prevRight
      prevRight = current.right
      current.right = prev
      prev = current
      current = next
    }
    prev
  }
}
