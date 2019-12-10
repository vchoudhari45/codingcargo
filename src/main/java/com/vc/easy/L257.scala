package com.vc.easy


class TreeNode257(var _value: Int) {
  var value: Int = _value
  var left: TreeNode257 = null
  var right: TreeNode257 = null
}

object L257 {
  def binaryTreePaths(root: TreeNode257): List[String] = {
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    val res = new mutable.ListBuffer[String]()
    def solve(root: TreeNode257, st: mutable.Stack[Int]): Unit = {
      if(root != null) {
        st.push(root.value)
        if(root.left == null && root.right == null) {
          res += st.reverse.mkString("->")
        }
        solve(root.left, st)
        solve(root.right, st)
        st.pop
      }
    }
    solve(root, st)
    res.toList
  }
}
