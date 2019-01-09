package com.vc.medium

object L763 {
  def partitionLabels(str: String): List[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, Int]()

    str.indices.foreach(i => {
      map.put(str(i), i)
    })

    var j = 0
    var from = 0
    val out = new mutable.ListBuffer[Int]()
    str.indices.foreach(i => {
      j = Math.max(j, map(str(i)))
      if(i == j) {
        out += j - from + 1
        from = i + 1
      }
    })
    out.toList
  }
}
