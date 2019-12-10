package com.vc.easy


class TreeNode872(var _value: Int) {
  var value: Int = _value
  var left: TreeNode872 = null
  var right: TreeNode872 = null
}

object L872 {
  import scala.collection.mutable
  def leafSimilar(root1: TreeNode872, root2: TreeNode872): Boolean = {
    val leaves1 = new mutable.ListBuffer[Int]()
    val leaves2 = new mutable.ListBuffer[Int]()
    getLeaves(root1, leaves1)
    getLeaves(root2, leaves2)
    leaves1 == leaves2
  }

  def getLeaves(node: TreeNode872, list: mutable.ListBuffer[Int]): Unit = {
    if(node != null) {
      if(node.right == null && node.left == null) list += node.value
      else {
        getLeaves(node.right, list)
        getLeaves(node.left, list)
      }
    }
  }
}