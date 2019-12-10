package com.vc.medium

object L1007 {
  def minDominoRotations(A: Array[Int], B: Array[Int]): Int = {
    val n = A.length

    //Assume A(0) is an answer
    var i = 0
    var a = 0
    var b = 0
    while(i < n && (A(0) == A(i) || A(0) == B(i))) {
      if(A(0) != A(i)) a += 1
      if(A(0) != B(i)) b += 1
      i += 1
      if(i >= n) return Math.min(a, b)
    }

    //Assume A(0) is an answer
    i = 0
    a = 0
    b = 0
    while(i < n && (B(0) == A(i) || B(0) == B(i))) {
      if(B(0) != A(i)) a += 1
      if(B(0) != B(i)) b += 1
      i += 1
      println(i)
      if(i >= n) return Math.min(a, b)
    }
    -1
  }
}
