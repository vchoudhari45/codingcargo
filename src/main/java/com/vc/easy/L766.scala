package com.vc.easy

object L766 {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    (1 until matrix.length).foreach(i => {
      (1 until matrix(i).length).foreach(j => {
        if(matrix(i)(j) != matrix(i - 1)(j - 1)) return false
      })
    })
    true
  }
}