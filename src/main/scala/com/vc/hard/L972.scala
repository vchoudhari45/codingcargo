package com.vc.hard

object L972 {
  def isRationalEqual(S: String, T: String): Boolean = {
    solve(S) == solve(T)
  }

  def solve(T: String): Double = {
    val toi = T.indexOf("(")
    if(toi != -1) {
      var tBase = T.substring(0, toi)
      val tDecimal = T.substring(toi + 1, T.length - 1)
      (0 to 20).foreach(i => tBase += tDecimal)
      return tBase.toDouble
    }
    T.toDouble
  }
}