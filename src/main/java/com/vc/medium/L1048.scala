package com.vc.medium

object L1048 {
  object WordSorting extends Ordering[String] {
    def compare(x: String, y: String): Int = x.length.compareTo(y.length)
  }
  def longestStrChain(words: Array[String]): Int = {
    //["a","b","ba","bca","bda","bdca"]
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    scala.util.Sorting.quickSort(words)(WordSorting)
    words.foreach(word => {
      var maxValue = 0
      word.indices.foreach(i => {
        val prevWord = word.substring(0, i) + word.substring(i + 1)
        maxValue = Math.max(maxValue, map.getOrElse(prevWord, 0) + 1)
      })
      map.put(word, maxValue)
    })
    map.maxBy(_._2)._2
  }
}
