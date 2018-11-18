package com.vc.easy

class TreeNode783(var _value: Int) {
  var value: Int = _value
  var left: TreeNode783 = null
  var right: TreeNode783 = null
}

object L783 {
  def minDiffInBST(root: TreeNode783): Int = {
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode783]()
    var current = root
    var res = Int.MaxValue
    var prev = -1
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.right
      }
      else {
        current = st.pop
        if(prev != -1) {
          res = Math.min(res, prev - current.value)
        }
        prev = current.value
        current = current.left
      }
    }
    res
  }
}
