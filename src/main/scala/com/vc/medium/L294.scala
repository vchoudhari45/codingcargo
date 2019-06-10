package com.vc.medium

object L294 {
  def canWin(s: String): Boolean = {
    val sArr = s.toCharArray
    def solve(): Boolean = {
      (0 until sArr.length - 1).foreach(i => {
        if(sArr(i) == '+' && sArr(i + 1) == '+') {
          sArr(i) = '-'
          sArr(i + 1) = '-'
          val oppWin = !solve()
          sArr(i) = '+'
          sArr(i + 1) = '+'
          if(oppWin) return true
        }
      })
      false
    }
    solve()
  }
}