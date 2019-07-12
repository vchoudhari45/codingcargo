package com.vc.hard

object L1092 {
  def shortestCommonSupersequence(str1: String, str2: String): String = {
    def getLCS(): String = {
      val n = str1.length
      val m = str2.length
      val dp = Array.ofDim[String](n + 1, m + 1)
      (0 to n).foreach(i => {
        (0 to m).foreach(j => {
          if(i == 0 || j == 0) dp(i)(j) = ""
          else if(str1(i - 1) == str2(j - 1)) {
            dp(i)(j) = dp(i - 1)(j - 1) + str1(i - 1)
          }
          else {
            dp(i)(j) = if(dp(i - 1)(j).length > dp(i)(j - 1).length) dp(i - 1)(j) else dp(i)(j - 1)
          }
        })
      })
      dp(n)(m)
    }

    val lcs = getLCS()
    var p1 = 0
    var p2 = 0
    import scala.collection.mutable
    val sb = new mutable.StringBuilder()
    lcs.foreach(ch => {
      while(p1 < str1.length && str1(p1) != ch) {
        sb.append(str1(p1))
        p1 += 1
      }
      while(p2 < str2.length && str2(p2) != ch) {
        sb.append(str2(p2))
        p2 += 1
      }
      sb.append(ch)
      p1 += 1
      p2 += 1
    })
    sb.append(str1.substring(p1)).append(str2.substring(p2)).toString
  }
}
