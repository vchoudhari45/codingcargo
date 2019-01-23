package com.vc.medium

object L723 {
  def candyCrush(board: Array[Array[Int]]): Array[Array[Int]] = {
    val n = board.length
    val m = board(0).length
    import scala.collection.mutable
    val set = new mutable.HashSet[(Int, Int)]()
    var found = true
    while(found) {
      found = false
      (0 until n).foreach(i => {
        (0 until m).foreach(j => {
          val e = board(i)(j)
          if(e != 0) {
            if(i + 2 < n && board(i + 1)(j) == e && board(i + 2)(j) == e) {
              found = true
              var k = i
              while(k < n && board(k)(j) == e) {
                set += ((k, j))
                k += 1
              }
            }
            if(j + 2 < m && board(i)(j + 1) == e && board(i)(j + 2) == e) {
              found = true
              var l = j
              while(l < m && board(i)(l) == e) {
                set += ((i, l))
                l += 1
              }
            }
          }
        })
      })

      (0 until m).foreach(j => {
        var top = n - 1
        var bottom = n - 1
        while(top >= 0) {
          if(set.contains((top, j))) {
            board(top)(j) = 0
            top -= 1
          }
          else {
            board(bottom)(j) = board(top)(j)
            bottom -= 1
            top -= 1
          }
        }
        while(bottom >= 0) {
          board(bottom)(j) = 0
          bottom -= 1
        }
      })
      set.clear
    }
    board
  }
}
