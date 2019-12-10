package com.vc.easy

object L409 {
  def longestPalindrome(s: String): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[Char]()
    var res = 0
    s.foreach(ch => {
      if(set.contains(ch)) {
        set.remove(ch)
        res += 2
      }
      else {
        set += ch
      }
    })
    if(s.length > res) res + 1 else res
  }
}