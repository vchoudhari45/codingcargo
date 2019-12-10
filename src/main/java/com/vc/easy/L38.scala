package com.vc.easy

object L38 {
  def countAndSay(n: Int): String = {
    var i = 1
    var str = "1"
    while(i < n) {
      str = solve(str)
      i += 1
    }
    str
  }

  def solve(str: String): String = {
    val n = str.length
    var i = 0
    import scala.collection.mutable
    val s = new mutable.StringBuilder
    while(i < n) {
      val char = str(i)
      var count = 0
      while(i < n && str(i) == char) {
        count += 1
        i += 1
      }
      s.append(count).append(char)
    }
    s.toString
  }
}
