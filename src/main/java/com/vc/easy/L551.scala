package com.vc.easy

object L551 {
  def checkRecord(s: String): Boolean = {
    val n = s.length
    var i = 0
    var lateCount = 0
    var absent = false
    while(i < n) {
      if(s(i) == 'L') {
        lateCount += 1
        if(lateCount > 2) return false
      }
      else {
        if(s(i) == 'A') {
          if(absent) return false
          absent = true
        }
        lateCount = 0
      }
      i += 1
    }
    true
  }
}