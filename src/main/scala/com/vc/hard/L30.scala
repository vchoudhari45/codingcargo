package com.vc.hard

object L30 {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[Int]()

    if(s.length == 0 || words.length == 0) return res.toList

    val map = new mutable.HashMap[String, Int]()
    words.foreach(word => {
      map.put(word, map.getOrElse(word, 0) + 1)
    })

    var i = 0
    val len = words(0).length
    while(i <= s.length - words.length * len) {
      val cur = new mutable.HashMap[String, Int]()
      cur ++= map
      var j = 0
      while(j < words.length) {
        val str = s.substring(i + j * len, i + j * len + len)
        if(cur.contains(str)) {
          cur.put(str, cur(str) - 1)
          if(cur(str) == 0) {
            cur.remove(str)
            if(cur.isEmpty) {
              res += i
              j = words.length //break
            }
          }
        }
        else j = words.length //break
        j += 1
      }
      i += 1
    }
    res.toList
  }
}