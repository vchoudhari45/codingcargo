package com.vc.medium

object L1053 {
  def prevPermOpt1(A: Array[Int]): Array[Int] = {
    val n = A.length
    var left = n - 2
    var right = n - 1
    while(left >= 0 && A(left) <= A(left + 1)) left -=1
    if(left < 0) return A
    while(A(left) <= A(right)) right -= 1
    while(A(right) == A(right - 1)) right -= 1
    val tmp = A(right)
    A(right) = A(left)
    A(left) = tmp
    A
  }
}