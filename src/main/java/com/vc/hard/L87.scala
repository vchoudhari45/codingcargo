package com.vc.hard

object L87 {
  import scala.collection.mutable
  val map = new mutable.HashMap[(String, String), Boolean]()
  def isScramble(s1: String, s2: String): Boolean = {
    if(map.contains((s1, s2))) return map(s1, s2)
    if(map.contains((s2, s1))) return map(s2, s1)
    if(s1 == s2) return true
    if(s1.length != s2.length) return false
    if(s1.length == 0) return true
    if(s1.length == 1) return s1 == s2
    if(s1.sorted != s1.sorted) return false

    (1 until s1.length).foreach(i => {
      //Take i characters from left side
      var s1Left = s1.substring(0, i)
      var s2Left = s2.substring(0, i)

      var s1Right = s1.substring(i)
      var s2Right = s2.substring(i)

      var leftCheck = isScramble(s1Left, s2Left)
      var rightCheck = isScramble(s1Right, s2Right)

      //Cache
      map.put((s1Left, s2Left), leftCheck)
      map.put((s1Right, s2Right), rightCheck)

      if(leftCheck && rightCheck) return true

      //This time we will take i characters from right side for s2
      s2Left = s2.substring(0, s2.length - i)
      s2Right = s2.substring(s2.length - i)

      //And also swap s2Right & s2Left because length should be matching
      leftCheck = isScramble(s1Left, s2Right)
      rightCheck = isScramble(s1Right, s2Left)

      //Cache
      map.put((s1Left, s2Right), leftCheck)
      map.put((s1Right, s2Left), rightCheck)

      if(leftCheck && rightCheck) return true
    })
    false
  }
}
