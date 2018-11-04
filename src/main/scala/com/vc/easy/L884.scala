package com.vc.easy

object L884 {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    (A + " "+ B).split(" ").foreach(str => {
      map.put(str, map.getOrElse(str, 0) + 1)
    })
    val arr = new mutable.ListBuffer[String]()
    map.foreach(x => if(x._2 == 1) arr += x._1)
    arr.toArray
  }
}
