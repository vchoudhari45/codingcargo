package com.vc.easy

object L521 {
  def findLUSlength(a: String, b: String): Int = if(a == b) -1 else Math.max(a.length, b.length)
}
