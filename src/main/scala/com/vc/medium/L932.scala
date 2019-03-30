package com.vc.medium

object L932 {
  def beautifulArray(N: Int): Array[Int] = {
    val arr = new Array[Int](N)
    (0 until N).foreach(i => arr(i) = i + 1)

    def solve(arr: Array[Int]): Array[Int] = {
      if(arr.length == 1) return arr
      import scala.collection.mutable
      val o = new mutable.ArrayBuffer[Int]()
      val e = new mutable.ArrayBuffer[Int]()
      arr.indices.foreach(i => {
        if(i % 2 == 0) e += arr(i)
        else o += arr(i)
      })
      val res = solve(e.toArray) ++ solve(o.toArray)
      res
    }
    solve(arr)
  }
}
