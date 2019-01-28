package com.vc.medium

class HitCounter() {

  /** Initialize your data structure here. */
  val interval = 300
  val arr = new Array[(Int, Int)](interval)

  /** Record a hit.
      @param timestamp - The current timestamp (in seconds granularity). */
  def hit(timestamp: Int): Unit = {
    val index = timestamp % interval
    if(arr(index) == null || arr(index)._1 != timestamp) arr(index) = (timestamp, 1)
    else arr(index) = (arr(index)._1, arr(index)._2 + 1)
  }

  /** Return the number of hits in the past 5 minutes.
      @param timestamp - The current timestamp (in seconds granularity). */
  def getHits(timestamp: Int): Int = {
    var res = 0
    arr.foreach(x => {
      if(x != null && timestamp - x._1 < 300) res += x._2
    })
    res
  }

}

/**
  * Your HitCounter object will be instantiated and called as such:
  * var obj = new HitCounter()
  * obj.hit(timestamp)
  * var param_2 = obj.getHits(timestamp)
  */
