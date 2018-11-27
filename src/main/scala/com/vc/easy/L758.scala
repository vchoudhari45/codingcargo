package com.vc.easy

object L758 {
  def boldWords(words: Array[String], S: String): String = {
    val n = S.length
    val bold = new Array[Boolean](n)
    words.foreach(word => {
      var idx = S.indexOf(word)
      while(idx != -1) {
        (idx until idx + word.length).foreach(i => {
          bold(i) = true
        })
        idx = S.indexOf(word, idx)
      }
    })

    import scala.collection.mutable
    val str = new mutable.StringBuilder()
    var i = 0
    while(i < n) {
      if(bold(i)) {
        str.append("<b>")
        var j = i
        while(j < n && bold(j)) {
          str.append(S(j))
          j += 1
        }
        i = j
        str.append("</b>")
        if(i < n) str.append(S(i))
      }
      else str.append(S(i))
      i += 1
    }
    str.toString
  }
}
