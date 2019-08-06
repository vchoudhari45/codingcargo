package com.vc.hard

object L847 {
  def shortestPathLength(arr: Array[Array[Int]]): Int = {
    //Store all the visited node by 1 & un-visited node by 0
    import scala.collection.mutable
    val q = new mutable.Queue[(Int, Int)]()
    val visited = new mutable.HashSet[(Int, Int)]()

    val n = arr.length
    var target = 1
    arr.indices.foreach(i => {
      target = target | (1 << i)
      q.enqueue(((1 << i), i))
    })

    var res = 0
    while(q.nonEmpty) {
      var size = q.size
      while(size > 0) {
        val source = q.dequeue
        if(source._1 == target) return res
        if(!visited.contains(source)) {
          visited += source
          arr(source._2).foreach(dest => {
            val newState = source._1 | (1 << dest)
            q += ((newState, dest))
          })
        }
        size -= 1
      }
      res += 1
    }
    res
  }
}