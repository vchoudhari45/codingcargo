package com.vc.medium

object L311 {
  def multiply(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val nA = A.length
    val mA = A(0).length
    val mB = B(0).length
    val C = Array.ofDim[Int](nA, mB)
    (0 until nA).foreach(i => {
      (0 until mA).foreach(j => {
        if(A(i)(j) != 0) {
          (0 until mB).foreach(k => {
            if(B(j)(k) != 0) C(i)(k) += A(i)(j) * B(j)(k)
          })
        }
      })
    })
    C
  }
}
