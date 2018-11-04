package com.vc.easy

object L575 {
  def distributeCandies(candies: Array[Int]): Int = {
    import scala.collection.mutable
    val set = mutable.HashSet.empty[Int] ++ candies
    val n = candies.length
    val m = set.size
    if(m <= n / 2) m else n / 2
  }
}
