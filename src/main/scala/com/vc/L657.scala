package com.vc

object L657 {
  def judgeCircle(moves: String): Boolean = {
    var x = 0
    var y = 0
    moves.foreach({
      case 'U' => y += 1
      case 'D' => y -= 1
      case 'L' => x -= 1
      case 'R' => x += 1
    })
    x == 0 && y == 0
  }
}
