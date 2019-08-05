package com.vc.hard

object L761 {
  def makeLargestSpecial(S: String): String = {
    /**
            here is the process of 11011000:
            level 1 : 1 + makeLargestSpecial( 101100) + 0,
            level 2 : 10 + 1100.we need to makeLargestSpecial(10) and makeLargestSpecial(1100)
            level 3 : makeLargestSpecial(10) will just return 10, and makeLargestSpecial(1100) will return 1100
            go back to level 2, we need to sort 10 and 1100, it will be 1100, 10, now we swap once,
            go back to level 1, we join them together : 1 1100 10 0, end .
      */
    var count = 0
    import scala.collection.mutable
    val list = new mutable.ListBuffer[String]()
    var start = 0
    S.indices.foreach(end => {
      if(S(end) == '1') count += 1
      else count -= 1
      if(count == 0) {
        list += S(0) + makeLargestSpecial(S.substring(start + 1, end)) + S(S.length - 1)
        start = end + 1
      }
    })
    list.sorted.reverse.mkString("")
  }
}