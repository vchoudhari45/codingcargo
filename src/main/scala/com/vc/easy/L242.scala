package com.vc.easy

object L242 {
  def isAnagram(s: String, t: String): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    s.foreach(ch => {
      map.put(ch, map.getOrElse(ch, 0) + 1)
    })
    t.foreach(ch => {
      if(map.contains(ch) && map(ch) == 1) map.remove(ch)
      else map.put(ch, map.getOrElse(ch, 0) - 1)
    })
    map.isEmpty
  }
}
