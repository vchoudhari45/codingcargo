package com.vc.easy

object L389 {
  def findTheDifference(s: String, t: String): Char = {
    var charCode = t(s.length).toInt
    s.indices.foreach(i => {
      charCode += t(i)
      charCode -= s(i)
    })
    charCode.toChar
  }
}
