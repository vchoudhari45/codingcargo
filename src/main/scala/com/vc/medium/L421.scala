package com.vc.medium

object L421 {
  def findMaximumXOR(arr: Array[Int]): Int = {
    import scala.collection.mutable
    import scala.util.control.Breaks._
    var max = 0
    var mask = 0
    (31 to 0 by -1).foreach(i => {
      mask = mask | (1 << i)
      val set = new mutable.HashSet[Int]()
      arr.foreach(x => {
        set += (x & mask)
      })
      val potentialMax = max | (1 << i)
      breakable {
        set.foreach(x => {
          if(set.contains(x ^ potentialMax)) {
            max = potentialMax
            break
          }
        })
      }
    })
    max
  }
}
