package com.vc.medium

object L789 {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    val d = Math.abs(target(0)) + Math.abs(target(1))
    ghosts.foreach(g => {
      val gd = Math.abs(g(0) - target(0)) + Math.abs(g(1) - target(1))
      if(gd <= d) return false
    })
    true
  }
}
