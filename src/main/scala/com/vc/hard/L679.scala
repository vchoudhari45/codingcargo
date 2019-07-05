package com.vc.hard

object L679 {
  def judgePoint24(nums: Array[Int]): Boolean = {
    import scala.collection.mutable
    val arr = new mutable.ListBuffer[Double]()
    def solve(list: mutable.ListBuffer[Double]): Boolean = {
      if(list.size == 1 && Math.abs(24 - list.head) <= 1e-10) return true
      list.indices.foreach(i => {
        (i + 1 until list.size).foreach(j => {
          val possibilities = operators(list(i), list(j))
          possibilities.foreach(x => {
            val newList = new mutable.ListBuffer[Double]()
            newList += x
            list.indices.foreach(k => {
              if(k != i && k != j) {
                newList += list(k)
              }
            })
            if(solve(newList)) return true
          })
        })
      })
      false
    }
    def operators(a: Double, b: Double): List[Double] = {
      val list = new mutable.ListBuffer[Double]()
      list += (a + b)
      list += (a - b)
      list += (b - a)
      list += (a * b)
      if(a != 0) list += (b / a)
      if(b != 0) list += (a / b)
      list.toList
    }
    nums.foreach(x => arr += x.toDouble)
    solve(arr)
  }
}
