package com.vc.medium

object L249 {
  def groupStrings(strings: Array[String]): List[List[String]] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, mutable.ListBuffer[String]]()
    val res = new mutable.ListBuffer[List[String]]()
    strings.foreach(s => {
      val offset = s(0) - 'a'
      var sum = ""
      s.foreach(ch => {
        var c = ch - offset
        if(c < 'a') c += 26
        sum += c
      })
      val list = map.getOrElse(sum, new mutable.ListBuffer[String]())
      list += s
      map.put(sum, list)
    })
    map.foreach(x => {
      res += x._2.toList.sorted
    })
    res.toList
  }
}
