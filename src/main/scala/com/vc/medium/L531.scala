package com.vc.medium

object L531 {
  def findLonelyPixel(picture: Array[Array[Char]]): Int = {
    val n = picture.length
    val m = picture(0).length

    val row = new Array[Int](n)
    val col = new Array[Int](m)

    picture.indices.foreach(i => {
      picture(i).indices.foreach(j => {
        if(picture(i)(j) == 'B') {
          row(i) += 1
          col(j) += 1
        }
      })
    })

    var res = 0
    picture.indices.foreach(i => {
      picture(i).indices.foreach(j => {
        if(picture(i)(j) == 'B') {
          if(row(i) == 1 && col(j) == 1) res += 1
        }
      })
    })
    res
  }
}