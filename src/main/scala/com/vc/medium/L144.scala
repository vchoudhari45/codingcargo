package com.vc.medium


class TreeNodeL144(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL144 = null
  var right: TreeNodeL144 = null
}

object L144 {
  def preorderTraversal(root: TreeNodeL144): List[Int] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    def solve(root: TreeNodeL144): Unit = {
      if(root != null) {
        list += root.value
        solve(root.left)
        solve(root.right)
      }
    }
    solve(root)
    list.toList
  }
}
