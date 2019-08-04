package com.vc.hard

object L527 {
  def wordsAbbreviation(dict: List[String]): List[String] = {
    import scala.collection.mutable
    val arr = new Array[(String, Int)](dict.length)

    //Generate a list with prefix = 1
    dict.indices.foreach(i => {
      val abbr = makeAbbr(dict(i), 1)
      arr(i) = (abbr, 1)
    })

    //Increase abbr prefix for those words whose abbr have conflict
    dict.indices.foreach(i => {
      resolveConflict(i)
    })

    def resolveConflict(from: Int): Unit = {
      while(true) {
        val set = new mutable.HashSet[Int]()
        (from + 1 until dict.length).foreach(j => {
          if(arr(from) == arr(j)) set += j
        })
        if(set.isEmpty) return
        set += from
        set.foreach(i => {
          val abbr = makeAbbr(dict(i), arr(i)._2 + 1)
          arr(i) = (abbr, arr(i)._2 + 1)
        })
      }
    }

    def makeAbbr(word: String, prefix: Int): String = {
      if(prefix >= word.length - 2) return word
      val sb = new mutable.StringBuilder()
      sb.append(word.substring(0, prefix))
      sb.append(word.length - 1 - prefix)
      sb.append(word(word.length - 1))
      return sb.toString
    }
    arr.map(x => x._1).toList
  }
}
