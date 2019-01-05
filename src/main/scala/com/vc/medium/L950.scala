package com.vc.medium

object L950 {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val n = deck.length

    java.util.Arrays.sort(deck)

    val q = new mutable.Queue[Int]()
    (0 until n).foreach(i => q.enqueue(i))

    var i = 0
    val res = new Array[Int](n)
    while(i < n) {
      res(q.dequeue) = deck(i)
      if(q.nonEmpty)q.enqueue(q.dequeue)
      i += 1
    }
    res
  }
}
