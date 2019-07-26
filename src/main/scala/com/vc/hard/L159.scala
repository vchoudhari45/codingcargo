package com.vc.hard

object L159 {
  def lengthOfLongestSubstringTwoDistinct(s: String): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    var start = 0
    var end = 0
    var res = 0
    while(end < s.length) {
      val add = s(end)
      map.put(add, map.getOrElse(add, 0) + 1)

      while(map.size > 2) {
        val remove = s(start)
        if(map(remove) - 1 == 0) map.remove(remove)
        else map.put(remove, map(remove) - 1)
        start += 1
      }

      res = Math.max(res, end - start + 1)
      end += 1
    }
    res
  }
}