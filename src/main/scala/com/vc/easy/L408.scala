package com.vc.easy

object L408 {
  def validWordAbbreviation(word: String, abbr: String): Boolean = {
    word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"))
  }
}
