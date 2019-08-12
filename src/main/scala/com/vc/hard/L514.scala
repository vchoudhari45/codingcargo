package com.vc.hard

object L514 {
  def findRotateSteps(ring: String, key: String): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, mutable.HashMap[Int, Int]]()

    def find(ring: String, ch: Char): Int = {
      var i = ring.length - 1
      while(i >= 0) {
        if(ring(i) == ch) return i
        i -= 1
      }
      i
    }

    def solve(ring: String, index: Int): Int = {
      if(index == key.length) return 0
      val ch = key(index)
      if(map.contains(ring) && map(ring).contains(index)) return map(ring)(index)
      val forwardMove = ring.indexOf(ch)
      val backwardMove = find(ring, ch)
      val forwardTotal = 1 + forwardMove + solve(ring.substring(forwardMove) + ring.substring(0, forwardMove), index + 1)
      val backwardTotal = 1 + ring.length - backwardMove + solve(ring.substring(backwardMove) + ring.substring(0, backwardMove), index + 1)
      val res = Math.min(forwardTotal, backwardTotal)
      val ringMap = map.getOrElse(ring, new mutable.HashMap[Int, Int])
      ringMap.put(index, res)
      map.put(ring, ringMap)
      res
    }
    solve(ring, 0)
  }
}