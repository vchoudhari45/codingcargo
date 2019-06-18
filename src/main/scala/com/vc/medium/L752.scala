package com.vc.medium

object L752 {
  def openLock(arr: Array[String], target: String): Int = {
    import scala.collection.mutable
    val end = new mutable.HashSet[String]()
    val start = "0000"
    arr.foreach(x => end += x)
    if(end.contains(start)) return -1
    var res = Int.MaxValue
    val q = new mutable.Queue[(String, Int)]()
    val visited = new mutable.HashSet[String]()
    q.enqueue((start, 0))
    while(q.nonEmpty) {
      val e = q.dequeue()
      (0 until 4).foreach(i => {
        val ch = e._1(i)
        val s1 = e._1.substring(0, i) + (if(ch == '9') 0 else ch - '0' + 1) + e._1.substring(i + 1)
        val s2 = e._1.substring(0, i) + (if(ch == '0') 9 else ch - '0' - 1) + e._1.substring(i + 1)

        if(s1 == target) {
          res = Math.min(res, e._2 + 1)
        }
        else if(!visited.contains(s1) && !end.contains(s1)){
          q.enqueue((s1, e._2 + 1))
          visited += s1
        }

        if(s2 == target) {
          res = Math.min(res, e._2 + 1)
        }
        else if(!visited.contains(s2) && !end.contains(s2)){
          q.enqueue((s2, e._2 + 1))
          visited += s2
        }
      })
    }
    if(res == Int.MaxValue) -1 else res
  }
}


