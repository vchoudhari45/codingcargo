package com.vc.easy

object L832 {
  def flipAndInvertImage(arr: Array[Array[Int]]): Array[Array[Int]] = {
    arr.indices.foreach(i => {
      arr(i) = arr(i).reverse
    })

    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        arr(i)(j) = arr(i)(j) ^ 1
      })
    })
    arr
  }
}
