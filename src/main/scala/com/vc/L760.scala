package com.vc

object L760 {
  def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val indexes = new mutable.HashMap[Int, Int]()
    B.indices.foreach(i => indexes.put(B(i), i))
    A.map(indexes(_))
  }
}
