package com.vc.medium

object L79 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val n = board.length
    if(n == 0) return false
    val m = board(0).length
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    import scala.collection.mutable
    val visited = new mutable.HashSet[(Int, Int)]()
    def solve(x: Int, y: Int, index: Int): Boolean = {
      if(index == word.length) return true
      if(!visited.contains((x, y))) {
        if(index + 1 == word.length && word(index) == board(x)(y)) return true
        visited += ((x, y))
        if(word(index) == board(x)(y)) {
          dirs.foreach(dir => {
            val xNew = x + dir._1
            val yNew = y + dir._2
            if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m) {
              if(solve(xNew, yNew, index + 1)) return true
            }
          })
        }
        visited -= ((x, y))
      }
      return false
    }
    board.indices.foreach(i => {
      board(i).indices.foreach(j => {
        if(solve(i, j, 0)) return true
      })
    })
    false
  }
}
