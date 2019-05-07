package com.vc.medium

class TimeMap() {

  /** Initialize your data structure here. */
  import scala.collection.mutable
  import java.util
  val map = new mutable.HashMap[String, util.TreeMap[Int, String]]()

  def set(key: String, value: String, timestamp: Int): Unit = {
    val timeMap = map.getOrElse(key, new util.TreeMap[Int, String]())
    timeMap.put(timestamp, value)
    map.put(key, timeMap)
  }

  def get(key: String, timestamp: Int): String = {
    if(map.contains(key)) {
      val timeMap = map(key)
      return Option(timeMap.floorKey(timestamp)).fold("")(x => timeMap.get(x))
    }
    ""
  }

}

/**
  * Your TimeMap object will be instantiated and called as such:
  * var obj = new TimeMap()
  * obj.set(key,value,timestamp)
  * var param_2 = obj.get(key,timestamp)
  */