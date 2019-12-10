package com.vc.easy

object L720 {
  def longestWord(words: Array[String]): String = {
    import scala.collection.mutable
    scala.util.Sorting.quickSort(words)
    val set = new mutable.HashSet[String]()
    var res = ""
    words.foreach(word => {
      val n = word.length
      if(n == 1 || set.contains(word.substring(0, n -1))) {
        if(res.length < n) {
          res = word
        }
        set += word
      }
    })
    res
  }
}
