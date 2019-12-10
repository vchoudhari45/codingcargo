package com.vc.hard

object L815 {
  def numBusesToDestination(routes: Array[Array[Int]], S: Int, T: Int): Int = {
    import scala.collection.mutable
    /**
        [
          [1, 2, 7],
          [3, 6, 7]
        ]
    */
    if(S == T) return 0
    val map = new mutable.HashMap[Int, mutable.HashSet[Int]]()
    routes.indices.foreach(i => {
      routes(i).indices.foreach(j => {
        val set = map.getOrElse(routes(i)(j), new mutable.HashSet[Int]())
        set += i
        map.put(routes(i)(j), set)
      })
    })

    /**
      Map(
        2 -> Set(0),
        7 -> Set(0, 1),
        1 -> Set(0),
        3 -> Set(1),
        6 -> Set(1)
      )
    */
    val q = new mutable.Queue[Int]()
    val visited = new mutable.HashSet[Int]()
    q.enqueue(S)
    visited += S
    var res = 0
    while(q.nonEmpty) {
      val size = q.size
      res += 1
      var i = 0
      while(i < size) {
        val e = q.dequeue()
        if(map.contains(e)) {
          map(e).foreach(index => {
            routes(index).foreach(child => {
              if(!visited(child)) {
                visited += child
                if(child == T) return res
                q += child
              }
            })
          })
        }
        i += 1
      }
    }
    -1
  }
}
