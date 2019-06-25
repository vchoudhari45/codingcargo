package com.vc.medium

class Vector2D(arr: Array[Array[Int]]) {

  private val itr: Iterator[Array[Int]] = if(arr != null) arr.iterator else null
  private var row: Iterator[Int] = null
  getRow

  def getRow(): Unit = while(!hasNext && itr != null && itr.hasNext) row = itr.next.iterator

  def next(): Int = {
    getRow
    val n = row.next
    getRow
    n
  }

  def hasNext(): Boolean = row != null && row.hasNext

}

/**
  * Your Vector2D object will be instantiated and called as such:
  * var obj = new Vector2D(v)
  * var param_1 = obj.next()
  * var param_2 = obj.hasNext()
  */
