package com.vc.hard

object L291 {
  def wordPatternMatch(pattern: String, str: String): Boolean = {
    val pn = pattern.length
    val sn = str.length
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, String]()
    val substringSet = new mutable.HashSet[String]()

    def solve(p: Int, s: Int): Boolean = {
      if(p == pn && s == sn) return true
      else if(p == pn || s == sn) return false
      else {
        val c = pattern(p)
        //pattern is already assigned a str
        if(map.contains(c)) {
          val existingString = map(c)

          //Check if str has existingString starting at index s
          if(
            s + existingString.length <= sn &&
              existingString == str.substring(s, s + existingString.length)
          ) {
            //And rest of pattern & string matches
            if(solve(p + 1, s + existingString.length)) return true
          }
          return false
        }

        //Try to match pattern with substring from str
        (s until sn).foreach(i => {
          val strSubstring = str.substring(s, i + 1)

          if(!substringSet.contains(strSubstring)) {
            map.put(c, strSubstring)
            substringSet += strSubstring

            if(solve(p + 1, i + 1)) return true

            map.remove(c)
            substringSet.remove(strSubstring)
          }
        })
        return false
      }
    }
    solve(0, 0)
  }
}
