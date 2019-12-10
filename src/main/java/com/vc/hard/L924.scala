package com.vc.hard

object L924 {
  def minMalwareSpread(arr: Array[Array[Int]], initial: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.ListBuffer[Int]]()

    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(arr(i)(j) == 1) {
          val list = map.getOrElse(i, new mutable.ListBuffer[Int]())
          list += j
          map.put(i, list)
        }
      })
    })

    var maxSpread = -1
    var maxSpreadNode = 0
    var spread = 0
    val visited = new mutable.HashSet[Int]()

    def dfs(from: Int): Unit = {
      if(!visited.contains(from)) {
        spread += 1
        visited += from
        if(map.contains(from)) {
          map(from).foreach(to => {
            dfs(to)
          })
        }
      }
    }

    initial.foreach(i => {
      spread = 0
      dfs(i)
      visited.clear
      if(spread > maxSpread) {
        maxSpreadNode = i
        maxSpread = spread
      }
      else if(spread == maxSpread && maxSpreadNode > i) {
        maxSpreadNode = i
      }
    })
    maxSpreadNode
  }
}