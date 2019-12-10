package com.vc.medium

class TreeNode938(var _value: Int) {
  var value: Int = _value
  var left: TreeNode938 = null
  var right: TreeNode938 = null
}

object L938 {
  def rangeSumBST(root: TreeNode938, L: Int, R: Int): Int = {
    var sum = 0
    def solve(root:TreeNode938): Unit = {
      import scala.collection.mutable
      val st = new mutable.Stack[TreeNode938]()
      var current = root
      while(current != null || st.nonEmpty) {
        if(current != null) {
          if(current.value >= L && current.value <= R) sum += current.value
          st.push(current)
          current = current.left
        }
        else current = st.pop.right
      }
    }
    solve(root)
    sum
  }
}
