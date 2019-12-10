package com.vc.easy

object L506 {
  object PQOrdering extends Ordering[(Int, Int)]{
    def compare(x:(Int, Int), y:(Int, Int)) : Int = {
      val cmp = x._1.compareTo(y._1)
      if(cmp == 0) x._2.compareTo(y._2)
      else cmp
    }
  }
  def findRelativeRanks(nums: Array[Int]): Array[String] = {
    import scala.collection.mutable
    val pq = new mutable.PriorityQueue[(Int, Int)]()(PQOrdering)
    nums.indices.foreach(i => {
      pq += ((nums(i), i))
    })

    var i = 1
    val ans = new Array[String](nums.length)
    while(pq.nonEmpty) {
      val e = pq.dequeue
      if(i == 1) ans(e._2) = "Gold Medal"
      else if(i == 2) ans(e._2) = "Silver Medal"
      else if(i == 3) ans(e._2) = "Bronze Medal"
      else ans(e._2) = i.toString
      i += 1
    }
    ans
  }
}
