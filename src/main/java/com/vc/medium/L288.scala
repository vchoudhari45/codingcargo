package com.vc.medium

class ValidWordAbbr(words: Array[String]) {

  import scala.collection.mutable
  val map = new mutable.HashMap[String, String]()

  words.foreach(word => {
    val abbr = makeAbbr(word)
    if(map.contains(abbr)) {
      if(map(abbr) != word) map.put(abbr, "")
    }
    else map.put(abbr, word)
  })

  def makeAbbr(word: String): String = {
    if(word.length < 3) return word
    return word(0) + (word.length - 2).toString + word(word.length - 1)
  }

  def isUnique(word: String): Boolean = {
    val abbr = makeAbbr(word)
    !map.contains(abbr) || (map.contains(abbr) && map(abbr) == word)
  }

}

