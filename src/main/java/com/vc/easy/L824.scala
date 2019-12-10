package com.vc.easy

object L824 {
  def toGoatLatin(S: String): String = {
    import scala.collection.mutable
    val vowel = mutable.HashSet('a','e','i','o','u','A','E','I','O','U')
    val str = new mutable.StringBuilder()
    var i = 0
    var j = 0
    var k = 0
    var count = 0
    while(j < S.length) {
      i = j
      while(j < S.length && S(j) != ' ') j += 1

      count += 1
      if(vowel.contains(S(i))) {
        str.append(S.substring(i, j))
        str.append("ma")
      }
      else {
        str.append(S.substring(i + 1, j))
        str.append(S(i))
        str.append("ma")
      }

      k = 0
      while(k < count) {
        str.append("a")
        k += 1
      }
      j += 1
      if(j < S.length) str.append(" ")
    }
    str.toString
  }
}
