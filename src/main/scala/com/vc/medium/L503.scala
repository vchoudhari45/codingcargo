package com.vc.medium

object L503 {
  def nextGreaterElements(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    val next = Array.fill(n)(-1)
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    (0 until 2 * n).foreach(i => {
      val num = arr(i % n)
      while(st.nonEmpty && arr(st.head) < num) {
        next(st.pop) = num
      }
      if(i < n) st.push(i)
    })
    next
  }
}
