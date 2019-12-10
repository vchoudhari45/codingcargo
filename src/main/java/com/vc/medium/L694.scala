package com.vc.medium

object L694 {
  val dirs = Array((1, 0, "d"), (0, 1, "r"), (0, -1, "u"), (-1, 0, "l"))
  def numDistinctIslands(grid: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    def solve(x: Int, y: Int, xPos: Int, yPos: Int, dir: String, s: java.lang.StringBuilder): Unit = {
      grid(x)(y) = 0
      s.append(dir)
      var i = 0
      while(i < 4) {
        val dir = dirs(i)
        val xNew = x + dir._1
        val yNew = y + dir._2
        if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid(0).length
          && grid(xNew)(yNew) == 1) solve(xNew, yNew, xPos + dir._1, yPos + dir._2, dir._3, s)
        i += 1
      }
      s.append("b")
    }
    grid.indices.foreach(i => {
      grid(i).indices.foreach(j => {
        if(grid(i)(j) == 1) {
          val s = new java.lang.StringBuilder
          solve(i, j, 0, 0, "o", s)
          val str = s.toString
          if(!set.contains(str)) set += str
        }
      })
    })
    set.size
  }
}
