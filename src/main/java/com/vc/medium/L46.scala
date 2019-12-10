package com.vc.medium

object L46 {
  def permute(arr: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val list = new mutable.ArrayBuffer[Int]()
    val n = arr.length
    val visited = new Array[Boolean](n)
    def solve(): Unit = {
      if(list.size == n) res += list.toList
      else {
        (0 until n).foreach(i => {
          if(!visited(i)) {
            visited(i) = true
            list += arr(i)
            solve()
            list.remove(list.size - 1)
            visited(i) = false
          }
        })
      }
    }
    solve()
    res.toList
  }
}
