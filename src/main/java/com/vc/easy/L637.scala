package com.vc.easy

import scala.collection.mutable.ListBuffer


class TreeNode637(var _value: Int) {
  var value: Int = _value
  var left: TreeNode637 = null
  var right: TreeNode637 = null
}

object L637 {
  def averageOfLevels(root: TreeNode637): Array[Double] = {
    import scala.collection.mutable
    val q = new mutable.Queue[TreeNode637]()
    val res = new ListBuffer[Double]()
    q.enqueue(root)
    q.enqueue(null)
    var sum = 0.toDouble
    var count = 0
    while(q.nonEmpty) {
      val e = q.dequeue()
      if(e != null) {
        sum += e.value.toDouble
        count += 1
        if(e.left != null) q.enqueue(e.left)
        if(e.right != null) q.enqueue(e.right)
      }
      else {
        res += (sum / count)
        sum = 0
        count = 0
        if(q.nonEmpty) q.enqueue(null)
      }
    }
    res.toArray
  }
}
