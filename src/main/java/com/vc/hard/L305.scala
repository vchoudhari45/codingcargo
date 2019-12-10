package com.vc.hard

object L305 {
  def numIslands2(m: Int, n: Int, pos: Array[Array[Int]]): List[Int] = {
    val pn = pos.length
    val res = new Array[Int](pn)
    val rootArr = new Array[Int](m * n)
    rootArr.indices.foreach(i => {
      rootArr(i) = -1
    })
    def findRoot(root: Int): Int = {
      if(root != rootArr(root)) {
        return findRoot(rootArr(root))
      }
      else return root
    }
    var count = 0
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    pos.indices.foreach(i => {
      val px = pos(i)(0)
      val py = pos(i)(1)

      val land = px * n + py
      if(rootArr(land) == -1) {
        rootArr(land) = land
        var root = land
        count += 1

        dirs.foreach(dir => {
          val xNew = px + dir._1
          val yNew = py + dir._2
          val landNb = xNew * n + yNew
          if(xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && rootArr(landNb) != -1) {
            val rootNb = findRoot(landNb)
            if(rootNb != root) {
              rootArr(rootNb) = root
              count -= 1
            }
          }
        })
      }
      res(i) = count
    })
    res.toList
  }
}