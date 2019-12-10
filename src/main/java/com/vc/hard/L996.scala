package com.vc.hard

object L996 {
  def numSquarefulPerms(arr: Array[Int]): Int = {
    import scala.collection.mutable

    val countMap = new mutable.HashMap[Int, Int]()
    val squareMap = new mutable.HashMap[Int, mutable.HashSet[Int]]()

    arr.indices.foreach(i => {
      countMap.put(arr(i), countMap.getOrElse(arr(i), 0) + 1)
    })

    val n = arr.length
    var res = 0
    arr.indices.foreach(i => {
      (i + 1 until n).foreach(j => {
        val x = arr(i)
        val y = arr(j)
        val c = Math.sqrt(x + y)
        if(c == Math.floor(c)) {
          val setY = squareMap.getOrElse(x, mutable.HashSet[Int]())
          setY += y
          squareMap.put(x, setY)

          val setX = squareMap.getOrElse(y, mutable.HashSet[Int]())
          setX += x
          squareMap.put(y, setX)
        }
      })
    })

    def solve(num: Int, remaining: Int): Unit = {
      if(remaining == 0) res += 1
      else {
        countMap.put(num, countMap(num) - 1)
        if(squareMap.contains(num)) {
          squareMap(num).foreach(s => {
            if(countMap.getOrElse(s, 0) > 0) {
              solve(s, remaining - 1)
            }
          })
        }
        countMap.put(num, countMap(num) + 1)
      }
    }

    countMap.foreach(x => {
      solve(x._1, arr.length - 1)
    })
    res
  }
}