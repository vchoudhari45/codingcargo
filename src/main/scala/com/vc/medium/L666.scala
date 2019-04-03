package com.vc.medium

object L666 {
  def pathSum(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val tree = new mutable.HashMap[Int, Int]()
    var total = 0
    def traverse(node: Int, preSum: Int): Unit = {
      val level = node / 10
      val pos = node % 10

      val currentSum = preSum + tree(node)
      val left = (level + 1) * 10 + 2 * pos - 1
      val right = (level + 1) * 10 + 2 * pos

      if(!tree.contains(left) && !tree.contains(right)) total += currentSum

      if(tree.contains(left)) traverse(left, currentSum)
      if(tree.contains(right)) traverse(right, currentSum)
    }
    arr.foreach(x => {
      val pos = x / 10
      val value = x % 10
      tree.put(pos, value)
    })
    traverse(arr(0) / 10, 0)
    total
  }
}