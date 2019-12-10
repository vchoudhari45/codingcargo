package com.vc.easy

object L448 {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    nums.indices.foreach(i => {
      if( nums(Math.abs(nums(i)) - 1) > 0) nums(Math.abs(nums(i)) - 1) = nums(Math.abs(nums(i)) - 1) * -1
    })
    nums.indices.foreach(i => if(nums(i) > 0) list += (i + 1))
    list.toList
  }
}
