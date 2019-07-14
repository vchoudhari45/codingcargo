package com.vc.hard

object L132 {
  def minCut(s: String): Int = {
    val n = s.length
    val dp = new Array[Int](n)
    dp.indices.foreach(i => dp(i) = i)
    s.indices.foreach(mid => {
      var start = mid
      var end = mid
      while(start >= 0 && end < n && s(start) == s(end)) {
        val prevPalindromeCuts = if(start > 0) dp(start - 1) + 1 else 0
        dp(end) = Math.min(dp(end),  prevPalindromeCuts)
        start -= 1
        end += 1
      }

      start = mid - 1
      end = mid
      while(start >= 0 && end < n && s(start) == s(end)) {
        val prevPalindromeCuts = if(start > 0) dp(start - 1) + 1 else 0
        dp(end) = Math.min(dp(end), prevPalindromeCuts)
        start -= 1
        end += 1
      }
    })
    println(dp.mkString(", "))
    dp(n - 1)
  }
}