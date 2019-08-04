package com.vc.hard

object L773 {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    /**
            [
                [1,2,3],
                [4,0,5]
            ]
      */
    def generateState(): (String, Int) = {
      var start = ""
      board.indices.foreach(i => {
        board(i).indices.foreach(j => {
          start += board(i)(j)
        })
      })
      (start, start.indexOf('0'))
    }
    val target = "123450"
    val dirs = Array(
      Array(1, 3),
      Array(0, 2, 4),
      Array(1, 5),
      Array(0, 4),
      Array(1, 3, 5),
      Array(4, 2)
    )
    var res = 0
    import scala.collection.mutable
    val q = new mutable.Queue[(String, Int)]()
    val visited = new mutable.HashSet[String]()
    val start = generateState()
    q += start
    while(q.nonEmpty) {
      var size = q.size
      while(size > 0) {
        val e = q.dequeue()
        if(e._1 == target) return res
        if(!visited.contains(e._1)) {
          visited += e._1
          val oldIndex = e._2
          dirs(oldIndex).foreach(newIndex => {
            val c = e._1.toCharArray
            c(oldIndex) = c(newIndex)
            c(newIndex) = '0'
            q += ((c.mkString(""), newIndex))
          })
        }
        size -= 1
      }
      res += 1
    }
    -1
  }
}