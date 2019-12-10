package com.vc.hard

object L940 {
  def distinctSubseqII(s: String): Int = {
    /**
      * https://leetcode.com/problems/distinct-subsequences-ii/discuss/192017/C%2B%2BJavaPython-4-lines-O(N)-Time-O(1)-Space
      * aba
      *
      * Starts with a
      * existingTotal = None
      * appendingCurrentChTotal = a
      * existingTotal = a + None = a
      *
      * Then comes b
      * existingTotal = a
      * appendingCurrentChTotal = ab, b
      * existingTotal = ab, b, a
      *
      * Then comes a
      * existingTotal = ab, b, a
      * appendingCurrentChTotal = aba, ba, aa, a - a = aba, ba, aa
      * existingTotal = ab, b, a, aba, ba, aa
      */
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    var existingTotal = 0
    val mod = 1000000007
    s.foreach(ch => {
      val appendingCurrentChTotal = (existingTotal + 1 - map.getOrElse(ch, 0)) % mod
      existingTotal = (appendingCurrentChTotal + existingTotal) % mod
      map.put(ch, (map.getOrElse(ch, 0) + appendingCurrentChTotal) % mod)
    })
    (existingTotal + mod) % mod
  }
}