package com.vc.hard

class MajorityChecker(arr: Array[Int]) {

  import scala.collection.mutable
  val map = new mutable.HashMap[Int, mutable.ArrayBuffer[Int]]
  val n = arr.length

  arr.indices.foreach(i => {
    val arrBuf = map.getOrElse(arr(i), new mutable.ArrayBuffer[Int]())
    arrBuf += i
    map.put(arr(i), arrBuf)
  })

  println(map)
  def query(left: Int, right: Int, threshold: Int): Int = {
    map.foreach(e => {
      val arrBuf = e._2
      val l = binarySearch(left, false, arrBuf)
      val r = binarySearch(right, true, arrBuf)
      if(r - l + 1 >= threshold) return e._1
    })
    -1
  }

  def binarySearch(x: Int, lower: Boolean, arr: mutable.ArrayBuffer[Int]): Int = {
    var lo = 0
    var hi = arr.length - 1

    if(x <= arr(lo)) return 0
    else if(x >= arr(hi)) return hi

    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if(arr(mid) == x) return mid
      else if(arr(mid) < x) lo = mid + 1
      else hi = mid - 1
    }
    if(lower) hi else lo
  }

}

/**
  * Your MajorityChecker object will be instantiated and called as such:
  * var obj = new MajorityChecker(arr)
  * var param_1 = obj.query(left,right,threshold)
  */
