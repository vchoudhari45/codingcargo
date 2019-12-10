package com.vc.easy


class TreeNode437(var _value: Int) {
  var value: Int = _value
  var left: TreeNode437 = null
  var right: TreeNode437 = null
}

object L437 {
  def pathSum(root: TreeNode437, sum: Int): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    map.put(0, 1)
    var res = 0
    val target = sum
    def solve(root: TreeNode437, sumAcc:Int): Unit = {
      if(root != null) {
        val sumNew = sumAcc + root.value
        res += map.getOrElse(sumNew - target, 0)
        map.put(sumNew, map.getOrElse(sumNew, 0) + 1)
        solve(root.left, sumNew)
        solve(root.right, sumNew)
        map.put(sumNew, map(sumNew) - 1)
      }
    }
    solve(root, 0)
    res
  }
}
