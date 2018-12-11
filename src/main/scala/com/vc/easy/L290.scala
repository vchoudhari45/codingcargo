package com.vc.easy

object L290 {
  def wordPattern(pattern: String, str: String): Boolean = {
    val arr = str.split(" ")
    if(pattern.length != arr.length) return false

    import scala.collection.mutable
    val m1 = new mutable.HashMap[String, Int]()
    val m2 = new mutable.HashMap[Char, Int]()

    arr.indices.foreach(i => {
      if(m1.put(arr(i), i) != m2.put(pattern(i), i)) return false
    })
    true
  }
}
