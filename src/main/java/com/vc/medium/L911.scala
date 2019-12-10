package com.vc.medium

class L911(persons: Array[Int], times: Array[Int]){
  import scala.collection.mutable
  val timeLeadMap = new java.util.TreeMap[Int, Int]()
  val leadMap = new mutable.HashMap[Int, Int]()
  var lead = -1
  times.indices.foreach(i => {
    leadMap.put(persons(i), leadMap.getOrElse(persons(i), 0) + 1)
    if(leadMap(persons(i)) >= leadMap.getOrElse(lead, 0)) lead = persons(i)
    timeLeadMap.put(times(i), lead)
  })

  def q(t: Int): Int = {
    val floorKey = timeLeadMap.floorKey(t)
    return timeLeadMap.get(floorKey)
  }
}

