package com.vc.hard

object L1074 {
  def numSubmatrixSumTarget(arr: Array[Array[Int]], target: Int): Int = {
    /**
      * [
      *   [0,1,0],
      *   [1,1,1],
      *   [0,1,0]
      * ]
      */
    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length
    var res = 0
    var singleArray = new Array[Int](n)
    (0 until m).foreach(i => { //Start of the column
      singleArray = new Array[Int](n)
      (i until m).foreach(j => { //End of the column
        (0 until n).foreach(k => {
          singleArray(k) += arr(k)(j)
        })
        res += sumArraySum(singleArray)
      })
    })

    def sumArraySum(arr: Array[Int]): Int = {
      import scala.collection.mutable
      val map = new mutable.HashMap[Int, Int]()
      map.put(0, 1)
      var res = 0
      var sum = 0
      arr.indices.foreach(i => {
        sum += arr(i)
        if(map.contains(sum - target)) {
          res += map(sum - target)
        }
        map.put(sum, map.getOrElse(sum, 0) + 1)
      })
      res
    }
    res
  }
}