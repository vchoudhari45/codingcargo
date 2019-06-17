package com.vc.medium

object L1059 {
  def leadsToDestination(n: Int, edges: Array[Array[Int]], source: Int, destination: Int): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.ListBuffer[Int]]()
    edges.foreach(edge => {
      val x = edge(0)
      val y = edge(1)
      val list = map.getOrElse(x, new mutable.ListBuffer[Int]())
      list += y
      map.put(x, list)
    })
    val visited = new mutable.HashSet[Int]()
    def dfs(node: Int): Boolean = {
      if(!visited(node)) {
        if(map.contains(node)) {
          visited += node
          map(node).foreach(i => {
            val dfsValue = dfs(i)
            println(s"$i -> $dfsValue")
            if(!dfsValue) return false
          })
          visited.remove(node)
        }
        else return node == destination
      }
      else return false
      true
    }
    dfs(source)
  }
}
