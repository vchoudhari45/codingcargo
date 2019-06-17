package com.vc.medium

object L533 {
  def findBlackPixel(arr: Array[Array[Char]], N: Int): Int = {
    if(arr.length == 0) return 0
    val n = arr.length
    val m = arr(0).length
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    val col = new Array[Int](m)
    arr.indices.foreach(i => {
      var row = 0
      val sb = new mutable.StringBuilder
      arr(i).indices.foreach(j => {
        if(arr(i)(j) == 'B') {
          row += 1
          col(j) += 1
        }
        sb.append(arr(i)(j))
      })
      if(row == N) map.put(sb.toString, map.getOrElse(sb.toString, 0) + 1)
    })

    var res = 0
    map.foreach(x => {
      if(x._2 == N) {
        x._1.indices.foreach(i => {
          if(x._1(i) == 'B' && col(i) == N) {
            res += 1
          }
        })
      }
    })
    res * N
  }
}
