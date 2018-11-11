package com.vc.easy

object L217 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    import scala.collection.immutable
    val set = immutable.HashSet.empty[Int] ++ nums
    set.size != nums.length
  }
}
