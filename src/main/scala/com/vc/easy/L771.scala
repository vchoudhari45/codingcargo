package com.vc.easy

object L771 {
  def numJewelsInStones(J: String, S: String): Int = {
    import scala.collection.mutable
    val set = mutable.HashSet.empty[Char] ++ J
    var res =  0
    S.foreach(ch => if(set.contains(ch)) res += 1)
    res
  }
}
