package com.vc.easy

object L500 {
  def findWords(words: Array[String]): Array[String] = {
    val keys = List("qwertyuiop".toSet, "asdfghjkl".toSet, "zxcvbnm".toSet)

    def predicate(w: String) : Boolean = {
      if(w == "") return true

      var rowIdx = -1
      keys.indices.foreach(i => {
        if(keys(i).contains(w(0).toLower)) rowIdx = i
      })

      var i = 1
      while(i < w.length) {
        if(!keys(rowIdx).contains(w(i).toLower)) return false
        i += 1
      }
      true
    }
    words.filter(predicate)
  }
}
