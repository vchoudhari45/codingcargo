package com.vc.easy

object L383 {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    magazine.foreach(ch => {
      map.put(ch, map.getOrElse(ch, 0) + 1)
    })
    ransomNote.foreach(ch => {
      if(map.contains(ch)) {
        map.put(ch, map(ch) - 1)
        if(map(ch) < 0) return false
      }
      else return false
    })
    true
  }
}
