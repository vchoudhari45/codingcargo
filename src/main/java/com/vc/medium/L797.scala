package com.vc.medium

object L797 {
  def allPathsSourceTarget(arr: Array[Array[Int]]): List[List[Int]] = {
    val n = arr.length - 1
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.ListBuffer[Int]]()
    arr.indices.foreach(from => {
      val list = map.getOrElse(from, new mutable.ListBuffer[Int]())
      arr(from).foreach(to => {
        list += to
      })
      map.put(from, list)
    })

    map.foreach(x => {
      println(s"${x._1} -> ${x._2.mkString(", ")}")
    })

    val res = new mutable.ListBuffer[List[Int]]()
    val st = new mutable.Stack[Int]()
    dfs(0)
    def dfs(from: Int): Unit = {
      st.push(from)
      if(from == n) {
        res += st.reverse.toList
      }
      else {
        if(map.contains(from)) {
          map(from).foreach(to => dfs(to))
        }
      }
      st.pop
    }
    res.toList
  }
}
