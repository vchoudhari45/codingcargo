package com.vc.hard

object WordOrderingByLength extends Ordering[String] {
  def compare(x: String, y: String): Int = x.length.compareTo(y.length)
}
object L472 {
  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    import scala.collection.mutable
    import scala.util.Sorting.quickSort

    //Sort by length in ASC order
    quickSort(words)(WordOrderingByLength)

    def canForm(word: String, set: mutable.HashSet[String]): Boolean = {
      if(set.isEmpty) return false
      val n = word.length
      val dp = new Array[Boolean](n + 1)
      dp(0) = true
      (1 to n).foreach(i => {
        import scala.util.control.Breaks._
        breakable {
          (0 until i).foreach(j => {
            if(dp(j) && set.contains(word.substring(j, i))) {
              dp(i) = true
              break
            }
          })
        }
      })
      dp(n)
    }

    val list = new mutable.ListBuffer[String]()
    val set = new mutable.HashSet[String]()
    words.foreach(word => {
      if(canForm(word, set)) list += word
      set += word
    })
    list.toList
  }
}
