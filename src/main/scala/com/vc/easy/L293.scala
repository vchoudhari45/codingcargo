package com.vc.easy

object L293 {
  def generatePossibleNextMoves(s: String): List[String] = {
    import scala.collection.mutable
    val n = s.length
    val list = new mutable.ListBuffer[String]()
    var i = 0
    while(i < n - 1) {
      if(s(i) == '+' && s(i + 1) == '+') {
        val str = s.substring(0, i) + "--" + (if(i + 2 < n) s.substring(i + 2) else "")
        list += str
      }
      i += 1
    }
    list.toList
  }
}

