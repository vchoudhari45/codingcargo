package com.vc.hard

object L857 {
  def mincostToHireWorkers(quality: Array[Int], wage: Array[Int], K: Int): Double = {
    /**
            minimum cost so wage/quality should be minimum

            calculate wage/quality for each employee
            70/10 = 7
            50/20 = 2.5
            30/6  = 5

            Sort them in ascending order
            2.5
            5
            7

            To calculate minimum wage we need to know total sum of quality K employees are bringing
            so let's use tuple
            (2.5, 20)  (Wage/Quality Ration -> Quality)
            (5,   30)
            (7,   70)

            Now iterate over above tuple list and add them in priority queue
            once there are K elements in Priority Queue,
            We take sum of quality so far and multiple it with wage/quality ratio of current employee

            When we have more than K elements in Priority Queue
            We remove employee with highest quality and substract it from qualitysum so far
            And then multiple it wage to quality ratio
      */

    object WageOrdering extends Ordering[(Double, Int)] {
      def compare(x: (Double, Int), y: (Double, Int)): Int = x._1.compareTo(y._1)
    }

    import scala.collection.mutable
    val n = quality.length
    var i = 0
    val arr = new Array[(Double, Int)](n)
    while(i < n) {
      val wageToQualityRatio = wage(i).toDouble/quality(i)
      arr(i) = (wageToQualityRatio, quality(i))
      i += 1
    }
    scala.util.Sorting.quickSort(arr)(WageOrdering)

    val pq = new mutable.PriorityQueue[Int]()
    var res = Double.MaxValue
    var qualitySum = 0
    arr.foreach(x => {
      val wageToQualityRatio = x._1
      val quality = x._2
      pq += quality
      qualitySum += quality
      if(pq.size > K) qualitySum -= pq.dequeue
      if(pq.size == K) res = Math.min(res, qualitySum * wageToQualityRatio)
    })
    res
  }
}