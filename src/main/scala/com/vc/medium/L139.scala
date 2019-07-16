package com.vc.medium

object L139 {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    set ++= wordDict
    val n = s.length
    if(set.isEmpty) return false
    if(n == 0) return false
    val dp = new Array[Boolean](n + 1)
    dp(0) = true
    (1 to n).foreach(i => {
      import scala.util.control.Breaks._
      breakable {
        (0 until i).foreach(j => {
          if(dp(j) && set.contains(s.substring(j, i))) {
            dp(i) = true
            break
          }
        })
      }
    })
    dp(n)
  }
}
