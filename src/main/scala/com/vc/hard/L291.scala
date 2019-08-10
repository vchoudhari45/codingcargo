package com.vc.hard

object L291 {
  def wordPatternMatch(pattern: String, str: String): Boolean = {
    val pn = pattern.length
    val sn = str.length
    import scala.collection.mutable
    val map = new mutable.HashMap[Char, String]()
    val set = new mutable.HashSet[String]()

    def solve(p: Int, s: Int): Boolean = {
      if(p == pn && s == sn) return true
      if(p == pn || s == sn) return false

      val patternChar = pattern(p)
      //pattern is already assigned a str
      if(map.contains(patternChar)) {
        val existingSubstring = map(patternChar)

        //Check if str has existingString starting at index s
        if(
          s + existingSubstring.length <= sn &&
            existingSubstring == str.substring(s, s + existingSubstring.length)
        ) {
          //And rest of pattern & string matches
          if(solve(p + 1, s + existingSubstring.length)) return true
        }

        return false
      }

      //Try to match pattern with substring from str
      (s until sn).foreach(i => {
        val substring = str.substring(s, i + 1)

        if(!set.contains(substring)) {
          map.put(patternChar, substring)
          set += substring

          if(solve(p + 1, i + 1)) return true

          map.remove(patternChar)
          set.remove(substring)
        }
      })
      return false
    }
    solve(0, 0)
  }
}
