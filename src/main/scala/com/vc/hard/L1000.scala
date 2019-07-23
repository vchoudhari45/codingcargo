package com.vc.hard

object L1000 {
  def mergeStones(stones: Array[Int], K: Int): Int = {
    val n = stones.length
    if((n - 1) % (K - 1) > 0) return -1

    val prefix = new Array[Int](n + 1)
    prefix.indices.foreach(i => {
      if(i > 0) prefix(i) = prefix(i - 1) + stones(i - 1)
    })

    val dp = Array.ofDim[Int](n, n)
    (1 until n).foreach(len => {
      (0 until n - len).foreach(start => {
        val end = start + len
        dp(start)(end) = Int.MaxValue
        (start until end by K - 1).foreach(mid => {
          dp(start)(end) = Math.min(dp(start)(end), dp(start)(mid) + dp(mid + 1)(end))
        })

        //This is because we are not merging one stone at a time we are merging K - 1 stones
        //So in the end K - 1 stones remains, and we do final merge here
        if((end - start) % (K - 1) == 0) {
          dp(start)(end) += prefix(end + 1) - prefix(start)
        }
      })
    })

    dp.foreach(x => {
      println(x.mkString(", "))
    })
    dp(0)(n - 1)
  }
}
