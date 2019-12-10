package com.vc.easy

object L171 {
  def titleToNumber(s: String): Int = {
    var res = 0
    s.foreach(ch => {
      res = res * 26 + (ch - 'A' + 1)
    })
    res
  }
}
