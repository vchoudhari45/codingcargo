package com.vc.easy

object L243 {
  def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
    val n = words.length
    var res = Int.MaxValue
    var idx1 = -1
    var idx2 = -1
    words.indices.foreach(i => {
      if(words(i) == word1) idx1 = i
      else if(words(i) == word2) idx2 = i
      if(idx1 != -1 && idx2 != -1) res = Math.min(res, Math.abs(idx1 - idx2))
    })
    res
  }
}
