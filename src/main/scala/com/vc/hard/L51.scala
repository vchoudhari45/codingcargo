package com.vc.hard

object L51 {
  def solveNQueens(n: Int): List[List[String]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[String]]()
    val arr = Array.ofDim[Char](n, n)
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        arr(i)(j) = '.'
      })
    })

    def solve(row: Int): Unit = {
      if(row == n) {
        val l = new mutable.ListBuffer[String]()
        arr.indices.foreach(i => {
          l += arr(i).mkString("")
        })
        res += l.toList
      }
      else {
        (0 until n).foreach(col => {
          arr(row)(col) = 'Q'
          if(isValid(row, col)) solve(row + 1)
          arr(row)(col) = '.'
        })
      }
    }

    def isValid(row:Int, col: Int): Boolean = {
      var i = 0
      var j = col
      while(i < row) {
        if(arr(i)(j) == 'Q') return false
        i += 1
      }

      i = row - 1
      j = col - 1
      while(i >= 0 && j >= 0) {
        if(arr(i)(j) == 'Q') return false
        i -= 1
        j -= 1
      }

      i = row - 1
      j = col + 1
      while(i >= 0 && j < n) {
        if(arr(i)(j) == 'Q') return false
        i -= 1
        j += 1
      }
      true
    }
    solve(0)
    res.toList
  }
}
