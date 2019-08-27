package com.vc.hard

object L1163 {
  def lastSubstring(s: String): String = {
    import scala.collection.mutable
    var maxChar = '@'
    var maxCharIndexes = new mutable.HashSet[Int]()
    var i = 0

    while(i < s.length) {
      val ch = s(i)
      if(maxChar < ch) {
        maxChar = ch
        maxCharIndexes.clear()
      }
      if(maxChar == ch) maxCharIndexes += i
      while(i < s.length - 1 && s(i) == s(i + 1)) i += 1
      i += 1
    }

    var shift = 1
    while(maxCharIndexes.size != 1) {
      val nextLevel = new mutable.HashSet[Int]()
      val toDelete = new mutable.HashSet[Int]()
      var maxChar = '@'
      maxCharIndexes.foreach(index => {
        val newIndex = index + shift
        if(newIndex < s.length && !toDelete.contains(newIndex)) {
          if(maxChar < s(newIndex)) {
            maxChar = s(newIndex)
            nextLevel.clear
          }
          if(maxChar == s(newIndex)) {
            nextLevel += index
          }
          if(maxCharIndexes.contains(newIndex)) {
            toDelete += newIndex
          }
        }
      })
      toDelete.foreach(delIndex => {
        nextLevel.remove(delIndex)
      })
      maxCharIndexes = nextLevel
      shift += 1
    }
    s.substring(maxCharIndexes.head)
  }
}
