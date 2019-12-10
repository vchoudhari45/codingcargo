package com.vc.easy

object L266 {
  def canPermutePalindrome(s: String): Boolean = {
    import scala.collection.mutable
    val set = new mutable.HashSet[Char]()
    s.foreach(ch => {
      if(set.contains(ch)) set -= ch
      else set += ch
    })
    set.isEmpty || set.size == 1
  }
}
