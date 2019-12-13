package com.vc.easy

class TreeNode617(var _value: Int) {
  var value: Int = _value
  var left: TreeNode617 = null
  var right: TreeNode617 = null
}

object L617 {
  def mergeTrees(t1: TreeNode617, t2: TreeNode617): TreeNode617 = {
    if(t1 != null && t2 != null) {
      val t = new TreeNode617(t1.value + t2.value)
      t.left = mergeTrees(t1.left, t2.left)
      t.right = mergeTrees(t1.right, t2.right)
      t
    }
    else if(t1 != null) t1
    else if(t2 != null) t2
    else null
  }
}