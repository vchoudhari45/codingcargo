package com.vc.hard

object L980 {
  def uniquePathsIII(arr: Array[Array[Int]]): Int = {
    val dirs = Array((1, 0), (-1, 0), (0, 1), (0, -1))
    var res = 0
    var xs = 0
    var ys = 0
    var xe = 0
    var ye = 0
    var empty = 1
    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length
    def solve(x: Int, y: Int): Unit = {
      if(x == xe && y == ye && empty == 0) res += 1
      else {
        dirs.foreach(dir => {
          val xNew = dir._1 + x
          val yNew = dir._2 + y
          if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && arr(xNew)(yNew) >= 0) {
            arr(xNew)(yNew) = -2
            empty -= 1
            solve(xNew, yNew)
            arr(xNew)(yNew) = 0
            empty += 1
          }
        })
      }
    }
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(arr(i)(j) == 1) {
          xs = i
          ys = j
        }
        else if(arr(i)(j) == 2) {
          xe = i
          ye = j
        }
        else if(arr(i)(j) == 0) empty += 1
      })
    })
    arr(xs)(ys) = -2
    solve(xs, ys)
    res
  }
}