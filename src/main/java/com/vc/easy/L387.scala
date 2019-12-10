package com.vc.easy

object L387 {
  def firstUniqChar(s: String): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    s.foreach(ch => {
      map.put(ch, map.getOrElse(ch, 0) + 1)
    })
    s.indices.foreach(i => {
      if(map(s(i)) == 1) return i
    })
    -1
  }
}
