package com.vc.hard

object L336 {
  def palindromePairs(words: Array[String]): List[List[Int]] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    words.indices.foreach(i => {
      map.put(words(i), i)
    })
    val res = new mutable.ListBuffer[List[Int]]()
    def isPalindrome(str: String): Boolean = {
      var lo = 0
      var hi = str.length - 1
      while(lo <= hi) {
        if(str(lo) != str(hi)) return false
        lo += 1
        hi -= 1
      }
      true
    }
    words.indices.foreach(i => {
      (0 to words(i).length).foreach(j => {
        val str1 = words(i).substring(0, j)
        val str2 = words(i).substring(j)

        if(isPalindrome(str1)) {
          val str2Reverse = str2.reverse
          if(map.contains(str2Reverse)) {
            val k = map(str2Reverse)
            if(i != k) {
              val list = List(k, i)
              res += list
            }
          }
        }

        if(isPalindrome(str2) && str2.length != 0) {
          val str1Reverse = str1.reverse
          if(map.contains(str1Reverse)) {
            val k = map(str1Reverse)
            if(i != k) {
              val list = List(i, k)
              res += list
            }
          }
        }
      })
    })
    res.toList
  }
}
