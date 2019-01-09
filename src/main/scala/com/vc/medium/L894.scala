package com.vc.medium

class TreeNode894(var _value: Int) {
  var value: Int = _value
  var left: TreeNode894 = null
  var right: TreeNode894 = null
}

object Solution {
  def allPossibleFBT(N: Int): List[TreeNode894] = {
    import scala.collection.mutable
    val cache = new mutable.HashMap[Int, List[TreeNode894]]()
    def solve(n: Int): List[TreeNode894] = {
      val res = new mutable.ListBuffer[TreeNode894]()
      if(n == 1) {
        res += new TreeNode894(0)
        return res.toList
      }
      val nVar = n - 1
      (0 until nVar).foreach(i => {
        var leftList: List[TreeNode894] = null
        if(cache.contains(i)) {
          leftList = cache(i)
        }
        else {
          leftList = solve(i)
          cache.put(i, leftList)
        }

        var rightList: List[TreeNode894] = null
        if(cache.contains(nVar - i)) {
          rightList = cache(nVar - i)
        }
        else {
          rightList = solve(nVar - i)
          cache.put(nVar - i, rightList)
        }

        leftList.foreach(left => {
          rightList.foreach(right => {
            val current = new TreeNode894(0)
            current.left = left
            current.right = right
            res += current
          })
        })
      })
      res.toList
    }
    solve(N)
  }
}
