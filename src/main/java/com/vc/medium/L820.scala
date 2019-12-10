package com.vc.medium

object L820 {
  def minimumLengthEncoding(words: Array[String]): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    words.foreach(word => set += word)
    words.foreach(word => {
      (1 until word.length).foreach(i => {
        set.remove(word.substring(i))
      })
    })
    var res = 0
    set.foreach(x => res += x.length + 1)
    res
  }
}