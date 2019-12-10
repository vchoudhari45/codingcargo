package com.vc.medium

class TreeNode655(var _value: Int) {
  var value: Int = _value
  var left: TreeNode655 = null
  var right: TreeNode655 = null
}

object L655 {
  def printTree(root: TreeNode655): List[List[String]] = {
    val row = getHeight(root)
    val col = Math.pow(2, row).toInt - 1
    val res = Array.ofDim[String](row, col)
    def solve(row: Int, lo: Int, hi: Int, root: TreeNode655): Unit = {
      val mid = lo + (hi - lo) / 2
      res(row)(mid) = root.value.toString
      if(root.left != null) solve(row + 1, lo, mid, root.left)
      if(root.right != null) solve(row + 1, mid, hi, root.right)
    }
    solve(0, 0, col, root)
    res.map(_.map(e => if(e == null) "" else e).toList).toList
  }

  def getHeight(root: TreeNode655): Int = {
    if(root != null) return 1 + Math.max(getHeight(root.left), getHeight(root.right))
    0
  }
}

