package com.vc.medium


class TreeNodeL623(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL623 = null
  var right: TreeNodeL623 = null
}

object Solution {
  def addOneRow(root: TreeNodeL623, v: Int, d: Int): TreeNodeL623 = {
    if(d == 0 || d == 1) {
      val newRoot = new TreeNodeL623(v)
      if(d == 1) newRoot.left = root
      if(d == 0) newRoot.right = root
      return newRoot
    }
    else {
      if(root != null) {
        root.left = addOneRow(root, v, if(d > 2) d - 1 else 1)
        root.right = addOneRow(root, v, if(d > 2) d - 1 else 0)
      }
    }
    root
  }
}
