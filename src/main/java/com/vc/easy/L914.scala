package com.vc.easy

object L914 {
  def hasGroupsSizeX(arr: Array[Int]): Boolean = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()
    arr.foreach(x => {
      map.put(x, map.getOrElse(x, 0) + 1)
    })

    var res = 0
    map.foreach(x => {
      res = gcd(x._2, res)
    })
    res > 1
  }

  def gcd(a:Int, b:Int): Int = {
    if(b > 0) gcd(b, a % b) else a
  }
}
