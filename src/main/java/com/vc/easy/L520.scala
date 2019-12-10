package com.vc.easy

object L520 {
  def detectCapitalUse(word: String): Boolean = {
    var capital = 0
    val n = word.length
    word.foreach(ch => {
      if(ch >= 'A' && ch <= 'Z') capital += 1
    })
    capital == 0 || capital == n || (capital == 1 && n > 1 && word(0).isUpper)
  }
}
