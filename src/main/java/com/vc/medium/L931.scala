package com.vc.medium

object L931 {
  def minFallingPathSum(arr: Array[Array[Int]]): Int = {
    val n = arr.length
    val m = arr(0).length
    (1 until n).foreach(i => {
      (0 until m).foreach(j => {
        if(j == 0) {
          arr(i)(j) += Math.min(arr(i - 1)(j), arr(i - 1)(j + 1))
        }
        else if(j == n - 1) {
          arr(i)(j) += Math.min(arr(i - 1)(j), arr(i - 1)(j - 1))
        }
        else {
          arr(i)(j) += Math.min(arr(i - 1)(j), Math.min(arr(i - 1)(j - 1), arr(i - 1)(j + 1)))
        }
      })
    })
    arr(n - 1).min
  }
}
