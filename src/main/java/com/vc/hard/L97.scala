package com.vc.hard

object L97 {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    val n = s1.length
    val m = s2.length
    if(n + m != s3.length) return false
    val arr = Array.ofDim[Boolean](n + 1, m + 1)
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(i == 0 && j == 0) arr(i)(j) = true
        else if(i == 0) {
          //Take s1 until ith Index
          // && match current jth s2 character with (i + j - 1)th s3 character
          arr(i)(j) = arr(i)(j - 1) && s2(j - 1) == s3(i + j - 1)
        }
        else if(j == 0) {
          //Take s2 until jth Index
          // && match current ith s2 character with (i + j - 1)th s3 character
          arr(i)(j) = arr(i - 1)(j) && s1(i - 1) == s3(i + j - 1)
        }
        else {
          //Try both characters from s1 and s2 at ith & jth index resp
          arr(i)(j) = arr(i - 1)(j) && s1(i - 1) == s3(i + j - 1)
          arr(i)(j) = arr(i)(j) || arr(i)(j - 1) && s2(j - 1) == s3(i + j - 1)
        }
      })
    })
    arr(n)(m)
  }
}