package com.vc.hard

object L340 {
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    var start = 0
    var end = 0
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    val n = s.length
    var res = 0
    while(end < n) {
      val ch = s(end)
      map.put(ch, map.getOrElse(ch, 0) + 1)
      while(map.size > k) {
        val sch = s(start)
        map.put(sch, map(sch) - 1)
        if(map(sch) == 0) map.remove(sch)
        start += 1
      }
      res = Math.max(res, end - start + 1)
      end += 1
    }
    res
  }
}