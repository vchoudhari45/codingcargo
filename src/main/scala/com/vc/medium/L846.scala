package com.vc.medium

object L846 {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    hand.foreach(x => map.put(x, map.getOrElse(x, 0) + 1))

    val sortedSeq = map.toSeq.map(_._1).sorted
    sortedSeq.foreach(key => {
      val value = map(key)
      if(value > 0) {
        (W - 1 to 0 by -1).foreach(i => {
          val keyNew = key + i
          if(map.getOrElse(keyNew, 0) < value) return false
          map.put(keyNew, map(keyNew) - value)
        })
      }
    })
    true
  }
}
