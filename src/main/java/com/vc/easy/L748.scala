package com.vc.easy

object L748 {
  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
    import scala.collection.mutable
    val sourceMap = new mutable.HashMap[Char, Int]()

    def matchMap(targetMap:mutable.HashMap[Char, Int]): Boolean = {
      sourceMap.foreach(x => {
        if(!targetMap.contains(x._1) || targetMap(x._1) < x._2) return false
      })
      true
    }

    licensePlate.toLowerCase.foreach(ch => {
      if(Character.isLetter(ch)) sourceMap.put(ch, sourceMap.getOrElse(ch, 0) + 1)
    })

    var minLength = Int.MaxValue
    var res = ""
    words.foreach(word => {
      val targetMap = new mutable.HashMap[Char, Int]()
      word.toLowerCase.foreach(ch => {
        targetMap.put(ch, targetMap.getOrElse(ch, 0) + 1)
      })
      if(matchMap(targetMap)) {
        if(minLength > word.length) {
          minLength = word.length
          res = word
        }
      }
    })

    res
  }
}
