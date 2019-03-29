package com.vc.medium

object L529 {
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    val dirs = Array(
      (0, 1),
      (1, 1),
      (1, 0),
      (1, -1),
      (0, -1),
      (-1, -1),
      (-1, 0),
      (-1, 1)
    )
    val x = click(0)
    val y = click(1)
    if(board(x)(y) == 'M') {
      board(x)(y) = 'X'
    }
    else {
      import scala.collection.mutable
      val st = new mutable.Stack[(Int, Int)]()
      st.push((x, y))
      while(st.nonEmpty) {
        val e = st.pop
        var mine = 0
        val stInner = new mutable.Stack[(Int, Int)]()
        dirs.foreach(dir => {
          val xNew = e._1 + dir._1
          val yNew = e._2 + dir._2
          if(xNew >= 0 && yNew >= 0 && xNew < board.length && yNew < board(0).length) {
            if(board(xNew)(yNew) == 'M') mine += 1
            else if(board(xNew)(yNew) == 'E') stInner.push((xNew, yNew))
          }
        })
        if(mine > 0) {
          board(e._1)(e._2) = (mine + '0').toChar
        }
        else {
          board(e._1)(e._2) = 'B'
          while(stInner.nonEmpty) st.push(stInner.pop)
        }
      }
    }
    board
  }
}
