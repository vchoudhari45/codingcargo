package com.vc.easy

object L422 {
  def validWordSquare(words: List[String]): Boolean = {
    import scala.collection.mutable
    words.indices.foreach(i => {
      val h = words(i)
      val v = new mutable.StringBuilder()
      words.indices.foreach(j => {
        if(i < words(j).length) v.append(words(j)(i))
      })
      if(h != v.toString()) return false
    })
    true
  }
}