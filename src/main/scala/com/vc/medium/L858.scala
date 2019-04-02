package com.vc.medium

object L858 {
  def mirrorReflection(p: Int, q: Int): Int = {
    var pVar = p
    var qVar = q
    while(pVar % 2 == 0 && qVar % 2 == 0) {
      pVar /= 2
      qVar /= 2
    }
    if(pVar % 2 == 0) 2
    else if(qVar % 2 == 0) 0
    else 1
  }
}
