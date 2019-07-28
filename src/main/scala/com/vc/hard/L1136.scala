package com.vc.hard

object L1136 {
  def minimumSemesters(N: Int, arr: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.HashSet[Int]]()
    val indegree = new Array[Int](N + 1)
    arr.indices.foreach(i => {
      val relation = arr(i)
      val set = map.getOrElse(relation(0), new mutable.HashSet[Int]())
      set += relation(1)
      map.put(relation(0), set)
      indegree(relation(1)) += 1
    })

    val q = new mutable.Queue[Int]()
    (1 to N).foreach(i => {
      if(indegree(i) == 0) q.enqueue(i)
    })

    var res = 0
    val visited = new mutable.HashSet[Int]()
    while(q.nonEmpty) {
      var s = q.size
      while(s > 0) {
        val e = q.dequeue()
        if(!visited.contains(e)) {
          visited += e
          if(map.contains(e)) {
            map(e).foreach(listElement => {
              indegree(listElement) -= 1
              if(indegree(listElement) == 0) q.enqueue(listElement)
            })
          }
        }
        s -= 1
      }
      res += 1
    }
    if(indegree.count(_ == 0) == N + 1) res else -1
  }
}