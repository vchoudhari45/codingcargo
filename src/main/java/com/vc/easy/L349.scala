package com.vc.easy

object L349 {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val set = mutable.HashSet.empty[Int] ++ nums2
    val arr = new mutable.ArrayBuffer[Int]()
    nums1.foreach(x => {
      if(set.contains(x)) arr += x
    })
    arr.distinct.toArray
  }
}
