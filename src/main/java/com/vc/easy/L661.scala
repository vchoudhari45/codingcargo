package com.vc.easy

object L661 {
  def imageSmoother(arr: Array[Array[Int]]): Array[Array[Int]] = {
    val dirs = Array(
      (0, 1),
      (1, 0),
      (1, 1),
      (-1, -1),
      (1, -1),
      (-1, 1),
      (-1, 0),
      (0, -1)
    )

    val n = arr.length
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        var sum = 0
        var count = 1
        dirs.foreach(dir => {
          val x = dir._1 + i
          val y = dir._2 + j
          if(x >= 0 && x < n && y >= 0 && y < arr(i).length) {
            sum += (arr(x)(y) & 0xFF)
            count += 1
          }
        })
        sum += arr(i)(j)
        arr(i)(j) = arr(i)(j) | (sum / count) << 8
      })
    })

    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        arr(i)(j) = arr(i)(j) >> 8
      })
    })
    arr
  }
}
