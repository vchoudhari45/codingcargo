package com.vc.hard

object L329 {
  def longestIncreasingPath(arr: Array[Array[Int]]): Int = {
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))

    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length

    val cache = Array.ofDim[Int](n, m)
    def solve(x: Int, y: Int): Int = {
      if(cache(x)(y) > 0) return cache(x)(y)

      var max = 0
      val e = arr(x)(y)
      dirs.foreach(dir => {
        val xNew = dir._1 + x
        val yNew = dir._2 + y
        if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m) {
          if(arr(xNew)(yNew) < e) {
            max = Math.max(max, 1 + solve(xNew, yNew))
          }
        }
      })
      cache(x)(y) = max
      cache(x)(y)
    }

    var max = 0
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        max = Math.max(max, 1 + solve(i, j))
      })
    })
    max
  }
}