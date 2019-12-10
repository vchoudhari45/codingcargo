package com.vc.medium

object L386 {
  def lexicalOrder(n: Int): List[Int] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    def dfs(cur: Int): Unit = {
      if(cur <= n) {
        list += cur
        (0 to 9).foreach(i => {
          dfs(cur * 10 + i)
        })
      }
    }
    (1 to 9).foreach(i => dfs(i))
    list.toList
  }
}
