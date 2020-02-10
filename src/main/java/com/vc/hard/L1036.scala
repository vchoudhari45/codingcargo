package com.vc.hard

object L1036 {
  def isEscapePossible(blocked: Array[Array[Int]], source: Array[Int], target: Array[Int]): Boolean = {
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    import scala.collection.mutable
    val blockedSet = new mutable.HashSet[(Int, Int)]()
    blocked.foreach(x => {
      blockedSet += ((x(0), x(1)))
    })

    val q = new mutable.Queue[(Int, Int)]()
    val visited = new mutable.HashSet[(Int, Int)]()
    var level = 0

    def solve(sourceX: Int, sourceY: Int, targetX:Int, targetY: Int): Boolean = {
      q.enqueue((sourceX, sourceY))
      while(q.nonEmpty) {
        val size = q.size
        var i = 0
        while(i < size) {
          val e = q.dequeue()
          if(e._1 == targetX && e._2 == targetY) return true
          if(!visited.contains(e)) {
            visited += e
            dirs.foreach(dir => {
              val xNew = dir._1 + e._1
              val yNew = dir._2 + e._2
              if(
                xNew >= 0
                  && xNew <= 1000000
                  && yNew >= 0
                  && yNew <= 1000000
                  && !visited.contains((xNew, yNew))
                  && !blockedSet.contains((xNew, yNew))
              ) q.enqueue((xNew, yNew))
            })
          }
          i += 1
        }
        level += 1
        if(level >= 200) return true
      }
      false
    }

    val fromSourceToTarget = solve(source(0), source(1), target(0), target(1))

    q.clear()
    level = 0
    visited.clear()

    val fromTargetToSource = solve(target(0), target(1), source(0), source(1))

    fromSourceToTarget && fromTargetToSource
  }
}