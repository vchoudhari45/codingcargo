package com.vc.easy

object L762 {
  def countPrimeSetBits(L: Int, R: Int): Int = {
    import scala.collection.mutable
    val primes = mutable.HashSet(2, 3, 5, 7, 11, 13, 17, 19)
    var out = 0
    (L to R).foreach(x => {
      var n = x
      var res = 0
      while(n != 0) {
        if((n & 1) == 1) res += 1
        n = n >> 1
      }
      if(primes.contains(res)) out += 1
    })
    out
  }
}
