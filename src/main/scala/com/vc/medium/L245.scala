package com.vc.medium

object L245 {
  def shortestWordDistance(words: Array[String], word1: String, word2: String): Int = {
    var dist = Int.MaxValue.toLong
    var w1 = -dist
    var w2 = dist
    val same = word1 == word2
    words.indices.foreach(i => {
      val word = words(i)
      if(word == word1) {
        if(same) {
          w1 = w2
          w2 = i
        }
        else w1 = i
      }
      else if(word == word2) w2 = i
      dist = Math.min(dist, Math.abs(w2 - w1))
    })
    dist.toInt
  }
}