package com.vc.medium

object L861 {
  def matrixScore(arr: Array[Array[Int]]): Int = {
    val n = arr.length
    val m = arr(0).length

    //Flip all rows where arr(i)(0) == 0 so that binary number in row will be max number
    arr.indices.foreach(i => {
      if(arr(i)(0) == 0) flipRow(i)
    })

    //Flip all cols where number of zeros are more that number of ones
    arr(0).indices.foreach(j => {
      var colSum = 0
      arr.indices.foreach(i => {
        colSum += arr(i)(j)
      })
      if(colSum * 2 < n) flipCol(j)
    })

    def flipRow(row: Int): Unit = {
      arr(0).indices.foreach(i => {
        arr(row)(i) = arr(row)(i) ^ 1
      })
    }

    def flipCol(col: Int): Unit = {
      arr.indices.foreach(i => {
        arr(i)(col) = arr(i)(col) ^ 1
      })
    }

    var total = 0
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        total += arr(i)(j) * (1 << m - j - 1)
      })
    })
    total

  }
}
