package com.vc.hard

object L871 {
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val pq = new mutable.PriorityQueue[Int]()
    var stop = startFuel
    val n = stations.length
    var i = 0
    var refuels = 0
    while(stop < target) {
      while(i < n && stop >= stations(i)(0)) {
        pq += stations(i)(1)
        i += 1
      }
      if(pq.isEmpty) return -1
      stop += pq.dequeue()
      refuels += 1
    }
    refuels
  }
}
