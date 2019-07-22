package com.vc.hard

object L1044 {
  def longestDupSubstring(s: String): String = {
    val str = s.map(x => x.toInt - 'a'.toInt).toArray
    var lo = 0
    var hi = s.length
    while(lo < hi) {
      val mid = lo + (hi - lo) / 2
      if(searchPatternOfLength(str, mid) != -1) lo = mid + 1
      else hi = mid
    }
    val start = searchPatternOfLength(str, lo - 1)
    if(start != -1) s.substring(start, start + lo - 1) else ""
  }

  val base = 26
  val prime = Math.pow(2, 32).toLong
  def searchPatternOfLength(s: Array[Int], len: Int): Int = {
    var hash = 0.toLong
    var baseL = 1.toLong
    (0 until len).foreach(i => {
      hash = (hash * base + s(i)) % prime
      baseL = baseL * base % prime
    })

    import scala.collection.mutable
    val set = new mutable.HashSet[Long]()
    set += hash

    var rollingHash = hash
    var from = 0
    var to = len
    while(to < s.length) {
      rollingHash = (rollingHash * base - (s(from) * baseL % prime) + prime) % prime
      rollingHash = (rollingHash + s(to)) % prime
      if(set.contains(rollingHash)) return from + 1
      from += 1
      to += 1
      set += rollingHash
    }
    -1
  }
}