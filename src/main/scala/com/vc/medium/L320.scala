package com.vc.medium

object L320 {
  def generateAbbreviations(word: String): List[String] = {
    import scala.collection.mutable
    val sb = new mutable.StringBuilder()
    val list = new mutable.ListBuffer[String]()
    val n = word.length
    def solve(pos:Int, count: Int): Unit = {
      val len = sb.length
      if(pos == n) {
        if(count > 0) sb.append(count)
        list += sb.toString
      }
      else {
        solve(pos + 1, count + 1)
        if(count > 0) sb.append(count)
        sb.append(word(pos))
        solve(pos + 1, 0)
      }
      sb.setLength(len)
    }
    solve(0, 0)
    list.toList
  }
}
