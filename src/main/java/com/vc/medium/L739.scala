package com.vc.medium

object L739 {
  def dailyTemperatures(arr: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    val n = arr.length
    val res = new Array[Int](n)
    (n - 1 to 0 by -1).foreach(i => {
      while(st.nonEmpty && arr(i) >= arr(st.head)) st.pop
      res(i) = if(st.nonEmpty) st.head - i else 0
      st.push(i)
    })
    res
  }
}