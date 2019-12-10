package com.vc.easy

object L917 {
  def reverseOnlyLetters(S: String): String = {
    val s = S.toCharArray
    var start = 0
    var end = s.length - 1
    while(start < end) {
      while(start < end && !Character.isLetter(s(start))) start += 1
      while(start < end && !Character.isLetter(s(end))) end -= 1
      val tmp = s(start)
      s(start) = s(end)
      s(end) = tmp
      start += 1
      end -= 1
    }
    s.mkString("")
  }
}
