package com.vc.hard

object L749 {
  def containVirus(arr: Array[Array[Int]]): Int = {
    val R = arr.length
    val C = arr(0).length
    var ans = 0

    var area = 0
    var maxArea = 0
    var walls = 0
    var maxWalls = 0
    var color = 0
    var row = 0
    var col = 0
    var visited = Array.ofDim[Int](R, C)
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))

    def solve(): Int = {
      maxArea = 0
      maxWalls = 0
      color = -2
      visited = Array.ofDim[Int](R, C)
      arr.indices.foreach(i => {
        arr(i).indices.foreach(j => {
          if(arr(i)(j) == 1 && visited(i)(j) == 0 ) {
            area = 0
            walls = 0
            dfs(i, j, color)
            if(area > maxArea) {
              maxArea = area
              maxWalls = walls
              row = i
              col = j
            }
            color -= 1
          }
        })
      })

      block(row, col)

      visited = Array.ofDim[Int](R, C)
      arr.indices.foreach(i => {
        arr(i).indices.foreach(j => {
          if(arr(i)(j) == 1 && visited(i)(j) == 0) {
            infect(i, j)
          }
        })
      })
      maxWalls
    }

    def block(x: Int, y: Int): Unit = {
      if(arr(x)(y) == 1) {
        arr(x)(y) = -1
        dirs.foreach(dir => {
          val xNew = dir._1 + x
          val yNew = dir._2 + y
          if(xNew >= 0 && xNew < R && yNew >= 0 && yNew < C) {
            block(xNew, yNew)
          }
        })
      }
    }

    def infect(x: Int, y: Int): Unit = {
      if(visited(x)(y) != 1 && arr(x)(y) != -1) {
        visited(x)(y) = 1
        if(arr(x)(y) == 0) arr(x)(y) = 1
        else {
          dirs.foreach(dir => {
            val xNew = dir._1 + x
            val yNew = dir._2 + y
            if(xNew >= 0 && xNew < R && yNew >= 0 && yNew < C) {
              infect(xNew, yNew)
            }
          })
        }
      }
    }

    def dfs(x: Int, y: Int, color: Int): Unit = {
      if(arr(x)(y) == 0) {
        walls += 1
        if(visited(x)(y) != color) {
          visited(x)(y) = color
          area += 1
        }
      }
      if(visited(x)(y) == 0 && arr(x)(y) == 1) {
        visited(x)(y) = color
        dirs.foreach(dir => {
          val xNew = dir._1 + x
          val yNew = dir._2 + y
          if(xNew >= 0 && xNew < R && yNew >= 0 && yNew < C) {
            dfs(xNew, yNew, color)
          }
        })
      }
    }

    while(true) {
      val walls = solve()
      ans += walls
      if(walls == 0) return ans
    }
    return ans
  }
}


