package com.vc.medium

object L36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    board.indices.foreach(i => {
      board(i).indices.foreach(j => {
        if(board(i)(j) != '.') {
          if(!set.add(s"${board(i)(j)} in ROW $i")) return false
          if(!set.add(s"${board(i)(j)} in COL $j")) return false
          if(!set.add(s"${board(i)(j)} in BLOCK ${i/3}, ${j/3}")) return false
        }
      })
    })
    true
  }
}
