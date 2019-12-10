package com.vc.medium


class TreeNode366(var _value: Int) {
  var value: Int = _value
  var left: TreeNode366 = null
  var right: TreeNode366 = null
}

object L366 {
  import scala.collection.mutable
  def findLeaves(root: TreeNode366): List[List[Int]] = {
    val map = new mutable.HashMap[Int, mutable.ListBuffer[Int]]()

    def height(root: TreeNode366): Int = {
      if(root == null) return 0
      val h = 1 + Math.max(height(root.left), height(root.right))
      val list = map.getOrElse(h, new mutable.ListBuffer[Int]())
      list += root.value
      map.put(h, list)
      h
    }

    height(root)
    val res = new Array[List[Int]](map.size)
    map.foreach(x => {
      res(x._1 - 1) = x._2.toList
    })
    res.toList
  }
}
