package com.vc.easy

object L438 {
  def findAnagrams(s: String, p: String): List[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    var start = 0
    var end = 0
    var target = p.length
    p.foreach(ch => {
      map.put(ch, map.getOrElse(ch, 0) + 1)
    })
    val n = s.length
    val arr = new mutable.ArrayBuffer[Int]()
    while(end < n) {
      val ch = s(end)
      if(map.contains(ch) && map(ch) > 0) {
        target -= 1
        map.put(ch, map(ch) - 1)
        if(target == 0) {
          arr += start
          map.put(s(start), map(s(start)) + 1)
          start += 1
          target += 1
        }
      }
      else if(map.contains(ch)) {
        map.put(s(start), map(s(start)) + 1)
        target += 1
        start += 1
        end -= 1
      }
      else {
        while(start < end) {
          map.put(s(start), map(s(start)) + 1)
          target += 1
          start += 1
        }
        start += 1
      }
      end += 1
    }
    arr.toList
  }
}
