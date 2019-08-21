package com.vc.hard

object L317 {
  def shortestDistance(arr: Array[Array[Int]]): Int = {
    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length

    val distance = Array.ofDim[Int](n, m)
    val reach = Array.ofDim[Int](n, m)
    var numberOfBuilding = 0

    import scala.collection.mutable
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(arr(i)(j) == 1) {
          numberOfBuilding += 1
          //Find distance of this building from all empty lands
          val visited = Array.ofDim[Int](n, m)
          val q = new mutable.Queue[(Int, Int)]()
          q += ((i, j))
          var level = 1
          while(q.nonEmpty) {
            val size = q.size
            var k = 0
            while(k < size) {
              val e = q.dequeue()
              val x = e._1
              val y = e._2
              dirs.foreach(dir => {
                val xNew = x + dir._1
                val yNew = y + dir._2
                if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && visited(xNew)(yNew) == 0 && arr(xNew)(yNew) == 0) {
                  distance(xNew)(yNew) += level
                  reach(xNew)(yNew) += 1
                  q.enqueue((xNew, yNew))
                  visited(xNew)(yNew) = 1
                }
              })
              k += 1
            }
            level += 1
          }
        }
      })
    })
    var res = Int.MaxValue
    distance.indices.foreach(i => {
      distance(i).indices.foreach(j => {
        if(reach(i)(j) == numberOfBuilding) {
          res = Math.min(res, distance(i)(j))
        }
      })
    })
    if(res == Int.MaxValue) -1 else res
  }
}