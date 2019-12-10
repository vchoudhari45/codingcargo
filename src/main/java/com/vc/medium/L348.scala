package com.vc.medium

class TicTacToe(n: Int) {

  /** Initialize your data structure here. */
  val rows = new Array[Int](n)
  val cols = new Array[Int](n)
  var diagonal = 0
  var antiDiagonal = 0

  /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
  @param col The column of the board.
  @param player The player, can be either 1 or 2.
  @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
  def move(row: Int, col: Int, player: Int): Int = {
    val toAdd = if(player == 1) 1 else -1

    rows(row) += toAdd
    cols(col) += toAdd

    if(col == row) diagonal += toAdd
    if(col == n - row - 1) antiDiagonal += toAdd

    if(
      Math.abs(rows(row)) == n ||
      Math.abs(cols(col)) == n ||
      Math.abs(diagonal) == n ||
      Math.abs(antiDiagonal) == n
    ) return player
    0
  }

}

/**
  * Your TicTacToe object will be instantiated and called as such:
  * var obj = new TicTacToe(n)
  * var param_1 = obj.move(row,col,player)
  */
