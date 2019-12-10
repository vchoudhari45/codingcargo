package com.vc.easy

object L867 {
  def transpose(arr: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.ofDim[Int](arr(0).length, arr.length)
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        res(j)(i) = arr(i)(j)
      })
    })
    res
  }
}
