package com.vc.easy

object L496 {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    val map = new mutable.HashMap[Int, Int]()
    nums2.foreach(x => {
      while(st.nonEmpty && st.head < x) map.put(st.pop, x)
      st.push(x)
    })
    nums1.indices.foreach(i => {
      nums1(i) = map.getOrElse(nums1(i), -1)
    })
    nums1
  }
}