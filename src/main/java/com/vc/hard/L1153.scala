package com.vc.hard

object L1153 {
  def canConvert(str1: String, str2: String): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Char]()
    val n = str1.length
    val m = str2.length
    if(str1 == str2) return true
    if(str2.distinct.length >= 26) return false
    if(n != m) return false
    str1.indices.foreach(i => {
      val ch1 = str1(i)
      val ch2 = str2(i)
      if(map.contains(ch1) && map(ch1) != ch2) return false
      map.put(ch1, ch2)
    })
    true
  }
}
