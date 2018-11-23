package com.vc.easy

object L925 {
  def isLongPressedName(name: String, typed: String): Boolean = {
    var i = 0
    var j = 0
    val n = name.length
    val m = typed.length
    while(i < n && j < m) {
      if(name(i) == typed(j)){
        i += 1
        j += 1
      }
      else if(j != 0 && typed(j) == typed(j - 1)) j += 1
      else return false
    }
    i == n
  }
}
