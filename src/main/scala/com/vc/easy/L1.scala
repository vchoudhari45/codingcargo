package com.vc.easy

object L1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    nums.indices.foreach(i => {
      val x = nums(i)
      if(map.contains(target - x)) {
        return Array(map(target - x), i)
      }
      else map.put(x, i)
    })
    Array(-1, -1)
  }
}
