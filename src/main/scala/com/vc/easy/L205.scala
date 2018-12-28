package com.vc.easy

object L205 {
  def isIsomorphic(s: String, t: String): Boolean = {
    import scala.collection.mutable
    if(s.length != t.length) return false
    val map = new mutable.HashMap[Char, Char]()
    val reverseMap = new mutable.HashMap[Char, Char]()
    s.indices.foreach(i => {
      if(map.contains(s(i)) && map(s(i)) != t(i)) return false
      else map.put(s(i), t(i))

      if(reverseMap.contains(t(i)) && reverseMap(t(i)) != s(i)) return false
      else reverseMap.put(t(i), s(i))
    })
    true
  }
}
