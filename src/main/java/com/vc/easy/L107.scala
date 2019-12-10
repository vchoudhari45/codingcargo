package com.vc.easy

import scala.collection.mutable


class TreeNode107(var _value: Int) {
  var value: Int = _value
  var left: TreeNode107 = null
  var right: TreeNode107 = null
}

object L107 {
  def levelOrderBottom(root: TreeNode107): List[List[Int]] = {
    val q = new mutable.Queue[TreeNode107]()
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ListBuffer[Int]()
    if(root == null) return res.toList
    q.enqueue(root)
    q.enqueue(null)
    while(q.nonEmpty) {
      val e = q.dequeue
      if(e != null) {
        list += e.value
        if(e.left != null) q.enqueue(e.left)
        if(e.right != null) q.enqueue(e.right)
      }
      else {
        res += list.toList
        list.clear
        if(q.nonEmpty) q.enqueue(null)
      }
    }
    res.toList
  }
}
