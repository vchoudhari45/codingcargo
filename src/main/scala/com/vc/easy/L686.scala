package com.vc.easy

object L686 {
  def repeatedStringMatch(A: String, B: String): Int = {
    val nA = A.length
    val nB = B.length
    val times = nB / nA
    val str = new StringBuilder()
    (0 to times + 1).foreach(i => {
      str.append(A)
      if(str.length >= nB && str.toString.contains(B)) return i + 1
    })
    -1
  }
}
