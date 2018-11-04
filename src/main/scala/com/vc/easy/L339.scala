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
    var sum = 0
    nestedList.foreach(x => depth(x, 1))
    def depth(nestedInteger: NestedInteger, d:Int): Unit = {
      if(nestedInteger.isInteger){
        sum += nestedInteger.getInteger * d
      }
      else {
        nestedInteger.getList.foreach(x => depth(x, d + 1))
      }
    }
    sum
  }
}
