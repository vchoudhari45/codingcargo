package com.vc.easy

class TwoSumProblem() {

  /** Initialize your data structure here. */
  import scala.collection.mutable
  val map = new mutable.HashMap[Int, Int]()

  /** Add the number to an internal data structure.. */
  def add(number: Int) {
    map.put(number, map.getOrElse(number, 0) + 1)
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  def find(value: Int): Boolean = {
    map.foreach(x => {
      val y = value - x._1
      if((x._1 == y && map(x._1) > 1) || (x._1 != y && map.contains(y))) return true
    })
    false
  }

}
