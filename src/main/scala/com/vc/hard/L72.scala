package com.vc.hard

object L72 {
  def minDistance(word1: String, word2: String): Int = {
    /**
                0 h o r s e
              0 0 1 2 3 4 5
              r 1 1 2 2 3 4
              o 2 2 1 2 3 4
              s 3 3 2 2 2 3
      */
    val n = word1.length
    val m = word2.length
    val res = Array.ofDim[Int](m + 1, n + 1)

    res.indices.foreach(i => {
      res(i).indices.foreach(j => {
        if(i == 0 && j == 0) res(i)(j) = 0
        else if(i == 0) res(i)(j) = j
        else if(j == 0) res(i)(j) = i
        else {
          if(word1(j - 1) == word2(i - 1)) {
            res(i)(j) = res(i - 1)(j - 1)
          }
          else {
            res(i)(j) = Math.min(Math.min(res(i - 1)(j - 1), res(i - 1)(j)), res(i)(j - 1)) + 1
          }
        }
      })
    })

    res.indices.foreach(i => {
      println(res(i).mkString(", "))
    })
    res(m)(n)
  }
}
