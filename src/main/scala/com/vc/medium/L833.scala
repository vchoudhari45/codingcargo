package com.vc.medium

object L833 {
  object IndexSorting extends Ordering[(Int, Int)] {
    def compare(x: (Int, Int), y: (Int, Int)): Int = y._1.compareTo(x._1)
  }
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    var s = S
    val indexesSorted = (for { i <- indexes.indices} yield (indexes(i), i)).toArray
    scala.util.Sorting.quickSort(indexesSorted)(IndexSorting)
    indexesSorted.foreach(index => {
      val indexNew = index._1
      val indexOld = index._2
      val source = sources(indexOld)
      val target = targets(indexOld)
      if(s.substring(indexNew, indexNew + source.length) == source) {
        s = s.substring(0, indexNew) + target + s.substring(indexNew + source.length)
      }
    })
    s
  }
}
