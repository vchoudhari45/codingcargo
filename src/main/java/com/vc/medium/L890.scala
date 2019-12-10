package com.vc.medium

object L890 {
  import scala.collection.mutable
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    val res = mutable.ListBuffer[String]()
    words.foreach(word => {
      if(isPatternMatch(word, pattern)) res += word
    })
    res.toList
  }

  def isPatternMatch(word: String, pattern: String): Boolean = {
    val mapFrom = new mutable.HashMap[Char, Char]()
    val mapTo = new mutable.HashMap[Char, Char]()
    if(word.length != pattern.length) return false
    word.indices.foreach(i => {
      val chFrom = word(i)
      val chTo = pattern(i)

      if(!mapFrom.contains(chFrom)) {
        mapFrom.put(chFrom, chTo)
      }

      if(!mapTo.contains(chTo)) {
        mapTo.put(chTo, chFrom)
      }

      if(mapFrom(chFrom) != chTo || mapTo(chTo) != chFrom) return false
    })
    true
  }
}
