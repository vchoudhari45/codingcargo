package com.vc.hard

object L992 {
  def subarraysWithKDistinct(arr: Array[Int], K: Int): Int = {
    import scala.collection.mutable

    val map = new mutable.HashMap[Int, Int]()
    val n = arr.length
    if(n == 0 || K > n) return 0
    var res = 0
    var prefix = 0
    var start = 0
    var end = 0
    while(end < n) {
      map.put(arr(end), map.getOrElse(arr(end), 0) + 1)

      //Remove duplicate prefix from left side if Map Size > K
      while(map.size > K){
        prefix = 0
        val oldStart = start
        start += map(arr(start))
        map.remove(arr(oldStart))
      }

      //For each duplicate on the left side increment prefix
      while(map.getOrElse(arr(start), 0) > 1) {
        map.put(arr(start), map(arr(start)) - 1)
        prefix += 1
        start += 1
      }

      //If map size is == K add prefix to result
      //For e.g. 1, 2, 1, 2, 3
      //prefix is [1, 2] which is repeating in [1, 2, 3] as well
      //So subarray with 3 distinct elements becomes
      // 1, 2, 1, 2, 3
      // 2, 1, 2, 3
      // 1, 2, 3
      if(map.size == K) res += prefix + 1
      end += 1
    }
    res
  }
}
