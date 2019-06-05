package com.vc.medium

object L286 {
  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    import scala.collection.mutable
    val q = new mutable.Queue[(Int, Int)]()
    rooms.indices.foreach(i => {
      rooms(i).indices.foreach(j => {
        if(rooms(i)(j) == 0) q.enqueue((i, j))
      })
    })

    val n = rooms.length
    val m = if(n > 0) rooms(0).length else 0
    while(q.nonEmpty) {
      val p = q.dequeue()
      val row = p._1
      val col = p._2
      if(row > 0 && rooms(row - 1)(col) == Int.MaxValue) {
        rooms(row - 1)(col) = rooms(row)(col) + 1
        q.enqueue((row - 1, col))
      }
      if(row < n - 1 && rooms(row + 1)(col) == Int.MaxValue) {
        rooms(row + 1)(col) = rooms(row)(col) + 1
        q.enqueue((row + 1, col))
      }
      if(col > 0 && rooms(row)(col - 1) == Int.MaxValue) {
        rooms(row)(col - 1) = rooms(row)(col) + 1
        q.enqueue((row, col - 1))
      }
      if(col < m - 1 && rooms(row)(col + 1) == Int.MaxValue) {
        rooms(row)(col + 1) = rooms(row)(col) + 1
        q.enqueue((row, col + 1))
      }
    }
  }
}
