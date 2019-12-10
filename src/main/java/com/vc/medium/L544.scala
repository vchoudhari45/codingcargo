package com.vc.medium

object L544 {
  def findContestMatch(n: Int): String = {
    import scala.collection.mutable
    var arr = new mutable.ArrayBuffer[String]()
    (0 until n).foreach(i => arr += (i + 1).toString)
    while(arr.size > 1) {
      val tmp = new mutable.ArrayBuffer[String]()
      while(arr.nonEmpty) {
        tmp += s"(${arr.remove(0)},${arr.remove(arr.size - 1)})"
      }
      arr = tmp
    }
    arr.head
  }
}