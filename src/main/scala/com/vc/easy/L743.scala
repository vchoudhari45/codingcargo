package com.vc.easy

object L743 {
  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.ArrayBuffer[(Int, Int)]]()
    times.foreach(x => {
      val fromNode = x(0)
      val toNode = x(1)
      val weight = x(2)
      val list = map.getOrElse(fromNode, new mutable.ArrayBuffer[(Int, Int)]())
      list += ((toNode, weight))
      map.put(fromNode, list)
    })

    val st = new mutable.Stack[Int]()
    val dist = new mutable.HashMap[Int, Int]()
    (1 to N).foreach(i => {
      dist.put(i, -1)
    })

    st.push(K)
    dist.put(K, 0)
    while(st.nonEmpty) {
      val fromNode = st.pop
      if(map.contains(fromNode)) {
        map(fromNode).foreach(e => {
          val toNode = e._1
          val weight = e._2
          if(dist(toNode) == -1 || dist(fromNode) + weight < dist(toNode)) {
            st.push(toNode)
            dist(toNode) =  dist(fromNode) + weight
          }
        })
      }
    }

    val max = dist.maxBy(_._2)._2
    val min = dist.minBy(_._2)._2
    if(min == -1) min else max
  }
}
