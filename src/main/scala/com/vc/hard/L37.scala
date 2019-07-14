package com.vc.hard

object L37 {
  def solveSudoku(board: Array[Array[Char]]): Unit = {
    def isValid(): Boolean = {
      import scala.collection.mutable
      val set = new mutable.HashSet[String]()
      (0 until 9).foreach(i => {
        (0 until 9).foreach(j => {
          val ch = board(i)(j)
          if(ch != '.') {
            if(
              !set.add(s"$ch in ROW $i") ||
                !set.add(s"$ch in COL $j") ||
                !set.add(s"$ch in BLOCK $i/3 & $j/3")
            )
              return false
          }
        })
      })
      return true
    }
    def solve(): Boolean = {
      (0 until 9).foreach(i => {
        (0 until 9).foreach(j => {
          if(board(i)(j) == '.') {
            ('1' to '9').foreach(num => {
              board(i)(j) = num
              if(isValid()) {
                if(solve()) return true
                else return false
              }
              else board(i)(j) = '.'
            })
            return false
          }
        })
      })
      true
    }
    solve()
  }

  def main(args: Array[String]): Unit = {
    solveSudoku(
      Array(
        Array('5','3','.','.','7','.','.','.','.'),
        Array('6','.','.','1','9','5','.','.','.'),
        Array('.','9','8','.','.','.','.','6','.'),
        Array('8','.','.','.','6','.','.','.','3'),
        Array('4','.','.','8','.','3','.','.','1'),
        Array('7','.','.','.','2','.','.','.','6'),
        Array('.','6','.','.','.','.','2','8','.'),
        Array('.','.','.','4','1','9','.','.','5'),
        Array('.','.','.','.','8','.','.','7','9')
      )
    )
  }
}