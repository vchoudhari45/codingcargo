package com.vc.medium

object L419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    //Idea is to make sure there is no X at the top and left side of current X
    var count = 0
    board.indices.foreach(i => {
      board(i).indices.foreach(j => {
        if(board(i)(j) == 'X' && (i == 0 || board(i - 1)(j) == '.') && (j == 0 || board(i)(j - 1) == '.')) count += 1
      })
    })
    count
  }
}
