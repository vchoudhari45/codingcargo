package com.vc.hard

object L85 {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    val n = matrix.length
    if(n == 0) return 0
    val m = matrix(0).length
    var res = 0
    val singleArray = new Array[Int](m)
    matrix.indices.foreach(i => {
      matrix(i).indices.foreach(j => {
        if(matrix(i)(j) == '0') singleArray(j) = 0 else singleArray(j) += matrix(i)(j) - '0'
      })
      val area = maxHistogram(singleArray)
      res = Math.max(area, res)
    })

    def maxHistogram(arr: Array[Int]): Int = {
      var max = 0
      import scala.collection.mutable
      val st = new mutable.Stack[Int]()
      var i = 0
      val n = arr.length
      var area = 0
      while(i < n) {
        if(st.isEmpty || arr(i) >= arr(st.head)) {
          st.push(i)
          i += 1
        }
        else {
          val top = st.pop
          if(st.isEmpty) area = arr(top) * i
          else area = arr(top) * (i - st.head - 1)
          max = Math.max(max, area)
        }
      }

      while(st.nonEmpty) {
        val top = st.pop
        if(st.isEmpty) area = arr(top) * i
        else area = arr(top) * (i - st.head - 1)
        max = Math.max(max, area)
      }
      max
    }
    res
  }
}
