package com.vc.easy

object L557 {
  def reverseWords(s: String): String = {
    val sArr = s.toCharArray
    var i = 0
    var j = 0
    val n = s.length
    while(i < n) {
      j = i
      while(j < n && sArr(j) != ' ') j += 1
      reverse(i, j - 1)
      i = j + 1
    }

    def reverse(s:Int, d: Int): Unit = {
      var source = s
      var dest = d
      while(source < dest) {
        val tmp = sArr(source)
        sArr(source) = sArr(dest)
        sArr(dest) = tmp
        source += 1
        dest -= 1
      }
    }
    sArr.mkString("")
  }
}
