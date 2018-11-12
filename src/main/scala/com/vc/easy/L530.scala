package com.vc.easy


class TreeNode530(var _value: Int) {
  var value: Int = _value
  var left: TreeNode530 = null
  var right: TreeNode530 = null
}

object Solution {
  def getMinimumDifference(root: TreeNode530): Int = {
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode530]()
    var current = root
    var res = Int.MaxValue
    var prev = -1
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.left
      }
      else {
        current = st.pop
        if(prev != -1) {
          res = Math.min(res, Math.abs(prev - current.value))
        }
        prev = current.value
        current = current.right
      }
    }
    res
  }
}
