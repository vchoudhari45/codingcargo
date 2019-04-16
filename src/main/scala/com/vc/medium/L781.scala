package com.vc.medium

object L781 {
  def numRabbits(arr: Array[Int]): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    arr.foreach(x => {
      map.put(x, map.getOrElse(x, 0) + 1)
    })

    var res = 0
    map.foreach(e => {
      val group = e._2 / (e._1 + 1)
      if(e._2 % (e._1 + 1) != 0)
        res += (group + 1) * (e._1 + 1) //All the rabbits in group weren't not asked so group + 1
      else
        res += group * (e._1 + 1)
    })
    res
  }
}
