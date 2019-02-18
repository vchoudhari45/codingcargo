package com.vc.medium


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger364 {

  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean = true

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int = 1

  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int): Unit = Unit

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList : List[NestedInteger364] = Nil

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger364): Unit = Unit
}

object L364 {
  def depthSumInverse(nestedList: List[NestedInteger364]): Int = {
    import scala.collection.mutable
    val q = new mutable.Queue[NestedInteger364]()
    nestedList.foreach(x => q.enqueue(x))
    var prev = 0
    var total = 0
    while(q.nonEmpty) {
      val size = q.size
      var levelSum = 0
      (0 until size).foreach(_ => {
        val e = q.dequeue
        if(e.isInteger) levelSum += e.getInteger
        else e.getList.foreach(x => q.enqueue(x))
      })
      prev += levelSum
      total += prev
    }
    total
  }
}
