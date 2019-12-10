package com.vc.easy

object L482 {
  def licenseKeyFormatting(S: String, K: Int): String = {
    val n = S.length
    import scala.collection.mutable
    val str = new mutable.StringBuilder
    var i = n - 1
    while(i >= 0) {
      if(S(i) != '-') {
        if(str.length % (K + 1) == K) str.append("-")
        str.append(S(i).toUpper)
      }
      i -= 1
    }
    str.reverse.toString
  }
}
