package com.vc.easy

object L888 {
  /**
    *   A.sum - a + b = B.sum + a - b
    *   (A.sum - B.sum) / 2 = a - b
    *   (A.sum - B.sum) / 2 + b = a
    **/
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val aSet = mutable.HashSet.empty[Int] ++ A
    val sumDiff = (A.sum - B.sum) / 2
    B.foreach(b => {
      if(aSet.contains(sumDiff + b)) return Array(sumDiff + b, b)
    })
    Array()
  }
}
