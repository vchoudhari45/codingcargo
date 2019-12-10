package com.vc.easy

object L408 {
  def validWordAbbreviation(word: String, abbr: String): Boolean = {
    var i = 0
    var j = 0
    val n = word.length
    val m = abbr.length
    while(i < n && j < m) {
      if(!Character.isDigit(abbr(j))) {
        if(word(i) == abbr(j)) {
          i += 1
          j += 1
        }
        else return false
      }
      else {
        var num = 0
        while(j < m && abbr(j) >= '0' && abbr(j) <= '9') {
          if(abbr(j) == '0' && num == 0) num += 1   //To avoid matching 01 with a
          num = num * 10 + abbr(j) - '0'
          j += 1
        }
        i += num
      }
    }
    !(i < n || j < m || i > n)
  }
}
