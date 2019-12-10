package com.vc.easy

class NestedInteger {
  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean = ???
  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int = ???
  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int) = ???
  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList: List[NestedInteger] = ???
  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger) = ???
}

object L339 {
  //[[1,1],2,[1,1]]
  def depthSum(nestedList: List[NestedInteger]): Int = {
    import scala.collection.mutable
    val q = new mutable.Queue[NestedInteger]()
    nestedList.foreach(list => q.enqueue(list))

    var sum = 0
    var level = 1
    while(q.nonEmpty) {
      val size = q.length
      var i = 0
      while(i < size) {
        val e = q.dequeue
        if(e.isInteger) sum += level * e.getInteger
        else e.getList.foreach(item => q.enqueue(item))
        i += 1
      }
      level += 1
    }
    sum
  }
}
