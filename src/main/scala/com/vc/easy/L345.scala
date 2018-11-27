package com.vc.easy

object L345 {
  def reverseVowels(s: String): String = {
    var i = 0
    val n = s.length
    var j = n - 1
    import scala.collection.mutable
    val set = new mutable.HashSet[Char]()
    List('a','e','i','o','u','A','E','I','O','U').foreach(ch => set += ch)
    val arr = s.toCharArray
    while(i < j) {
      while(i < j && !set.contains(s(i))) i += 1
      while(i < j && !set.contains(s(j))) j -= 1
      if(i < j) {
        val tmp = arr(i)
        arr(i) = arr(j)
        arr(j) = tmp
      }
      i += 1
      j -= 1
    }
    arr.mkString("")
  }
}
