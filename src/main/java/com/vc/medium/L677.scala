package com.vc.medium

class MapSum() {

  /** Initialize your data structure here. */
  import scala.collection.mutable
  val map = new mutable.HashMap[String, Int]()

  def insert(key: String, value: Int): Unit = map.put(key, value)

  def sum(prefix: String): Int = {
    var res = 0
    map.foreach(e => if(e._1.startsWith(prefix)) res += e._2)
    res
  }

}