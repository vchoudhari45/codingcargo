package com.vc.medium


class TreeNodeL337(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL337 = null
  var right: TreeNodeL337 = null
}

object L337 {
  def rob(root: TreeNodeL337): Int = {
    def solve(root: TreeNodeL337): (Int, Int) = {
      if(root == null) return (0, 0)
      val left = solve(root.left)
      val right = solve(root.right)
      val rob = root.value + left._2 + right._2
      val notRob = Math.max(left._1, left._2) + Math.max(right._1, right._2)
      (rob, notRob)
    }
    val (rob, notRob) = solve(root)
    Math.max(rob, notRob)
  }
}