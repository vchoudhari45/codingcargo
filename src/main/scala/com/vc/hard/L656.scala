package com.vc.hard

object L656 {
  def cheapestJump(A: Array[Int], B: Int): List[Int] = {
    val n = A.length
    //Original  [1,   2,   4,  -1,   2], 2
    //Cost      [1,   3,   5,  -1,   7], 2
    //PrevIndex [0,  -1,   0,  -1,   2]

    val cost = new Array[Int](n)
    val prev = Array.fill(n)(-1)
    val lexi = new Array[Int](n) // Will add more elements to o/p

    cost(0) = A(0)
    var i = 0
    var j = 0
    while(i < n) {
      if(A(i) != -1) {
        j = Math.max(0, i - B)
        while(j < i) {
          if(A(j) != -1) {
            val newCost = cost(j) + A(i)
            if(
              prev(i) == -1 ||
                newCost < cost(i) ||
                (newCost == cost(i) && lexi(i) < lexi(j) + 1)
            ) {
              cost(i) = newCost
              prev(i) = j
              lexi(i) = lexi(j) + 1
            }
          }
          j += 1
        }
      }
      i += 1
    }

    import scala.collection.mutable
    val list = new mutable.ListBuffer[Int]()
    i = n - 1
    while(i >= 0) {
      list += (i + 1)
      i = prev(i)
    }
    val res = list.reverse
    if(res.head == 1) res.toList else List.empty[Int]
  }
}
