package com.vc.easy

object L796 {
  def rotateString(A: String, B: String): Boolean = A.length == B.length && (A + A).contains(B)
}
