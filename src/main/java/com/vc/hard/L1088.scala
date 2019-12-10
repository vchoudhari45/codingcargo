package com.vc.hard

object L1088 {
  def confusingNumberII(N: Int): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Long, Long]()
    map.put(0, 0)
    map.put(1, 1)
    map.put(6, 9)
    map.put(8, 8)
    map.put(9, 6)

    var res = 0
    def solve(cur: Long): Unit = {
      if(cur > N) return
      if(!same(cur)) res += 1
      map.foreach(x => {
        if(cur == 0 && x._1 == 0) return
        solve(cur * 10 + x._1)
      })
    }

    def same(N: Long): Boolean = {
      var nVar = N
      var mirror = 0l
      while(nVar != 0) {
        val digit = nVar % 10
        nVar = nVar / 10
        if(!map.contains(digit)) return false
        mirror = mirror * 10 + map(digit)
      }
      mirror == N
    }
    solve(0)
    res
  }
}