package com.vc.medium

object L791 {
  def customSortString(S: String, T: String): String = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()
    T.foreach(ch => map.put(ch, map.getOrElse(ch, 0) + 1))

    val str = new mutable.StringBuilder
    def appendTimes(ch:Char, times: Int): Unit = (0 until times).foreach(_ => str.append(ch))

    S.foreach(ch => {
      if(map.contains(ch)) {
        appendTimes(ch, map(ch))
        map -= ch
      }
    })
    map.foreach(e => appendTimes(e._1, e._2))
    str.toString
  }
}
