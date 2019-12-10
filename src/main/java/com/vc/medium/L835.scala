package com.vc.medium

object L835 {
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val listA = new mutable.ListBuffer[(Int, Int)]()
    val listB = new mutable.ListBuffer[(Int, Int)]()
    val n = A.length
    val m = A(0).length
    (0 until n).foreach(i => {
      (0 until m).foreach(j => {
        if(A(i)(j) == 1) listA += ((i, j))
        if(B(i)(j) == 1) listB += ((i, j))
      })
    })
    val map = new mutable.HashMap[String, Int]()
    listA.foreach(eA => {
      listB.foreach(eB => {
        val x = eB._1 - eA._1
        val y = eB._2 - eA._2
        val distance = s"$x $y"
        map.put(distance, map.getOrElse(distance, 0) + 1)
      })
    })
    if(map.isEmpty) 0 else map.maxBy(_._2)._2
  }
}
