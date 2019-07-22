package com.vc.hard

object L1063 {
  def validSubarrays(arr: Array[Int]): Int = {
    /**
          [1,4,2,5,3]
          Next smaller element
      */
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    var res = 0
    val n = arr.length
    var i = n - 1
    while(i >= 0) {
      while(st.nonEmpty && arr(i) <= arr(st.head)) st.pop
      res += (if(st.nonEmpty) st.head - i else n - i)
      st.push(i)
      i -= 1
    }
    res
  }
}
