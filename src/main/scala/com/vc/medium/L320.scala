package com.vc.medium

object L320 {
  def generateAbbreviations(word: String): List[String] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[String]()
    val sb = new mutable.StringBuilder()

    def solve(currentIndex: Int, requiredLength: Int): Unit = {
      if(currentIndex >= word.length) return
      val prevNum = sb.nonEmpty && sb(sb.length - 1) >= '0' && sb(sb.length - 1) <= '9'
      if(requiredLength == 1) {
        if(currentIndex == word.length - 1) {
          sb.append(word(currentIndex))
          list += sb.toString
          sb.setLength(sb.length - 1)
        }
        if(!prevNum) {
          val remainingWordLength = word.length - currentIndex
          sb.append(remainingWordLength)
          list += sb.toString
        }
      }
      else {
        var endIndex = sb.length

        //Append character
        sb.append(word(currentIndex))
        solve(currentIndex + 1, requiredLength - 1)
        sb.delete(endIndex, sb.length)

        //Append number
        if(!prevNum) {
          (currentIndex + 1 until word.length).foreach(i => {
            sb.append(i - currentIndex)
            solve(i, requiredLength - 1)
            sb.delete(endIndex, sb.length)
          })
        }
      }
    }

    val res = new mutable.ListBuffer[String]()
    (1 to word.length).foreach(i => {
      list.clear
      sb.clear
      solve(0, i)
      res ++= list
    })
    if(word == "") res += ""
    res.toList
  }
}
