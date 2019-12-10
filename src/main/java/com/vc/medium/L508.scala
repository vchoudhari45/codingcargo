package com.vc.medium

class TreeNode508(var _value: Int) {
  var value: Int = _value
  var left: TreeNode508 = null
  var right: TreeNode508 = null
}


object L508 {
  def findFrequentTreeSum(root: TreeNode508): Array[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    def solve(root: TreeNode508): Int = {
      if(root != null) {
        val l = solve(root.left)
        val r = solve(root.right)
        val total = l + r + root.value
        map.put(total, map.getOrElse(total, 0) + 1)
        return total
      }
      0
    }

    val res = new mutable.ArrayBuffer[Int]()
    solve(root)
    if(map.nonEmpty) {
      val maxValue = map.maxBy(_._2)._2
      map.foreach(x => if(x._2 == maxValue) res += x._1)
    }
    res.toArray
  }
}
