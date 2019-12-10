package com.vc.medium

object L648 {
  def replaceWords(dict: List[String], sentence: String): String = {
    import scala.collection.mutable
    case class Node(child: mutable.HashMap[Char, Node], var isLeaf: Boolean)
    val root = Node(new mutable.HashMap[Char, Node], isLeaf = false)
    var i = 0
    while(i < dict.length) {
      val word = dict(i)
      var j = 0
      var current = root
      while(j < word.length) {
        val ch = word(j)
        if(!current.child.contains(ch)) {
          val node = Node(new mutable.HashMap[Char, Node], isLeaf = false)
          current.child.put(ch, node)
        }
        if(j == word.length - 1) current.child(ch).isLeaf = true
        current = current.child(ch)
        j += 1
      }
      i += 1
    }

    val str = new mutable.StringBuilder()
    i = 0
    val words = sentence.split(" ")
    while(i < words.length) {
      val newWord = new mutable.StringBuilder
      val word = words(i)
      var current = root
      var flag = false
      var j = 0
      while(j < word.length) {
        val ch = word(j)
        if(current.child.contains(ch)) {
          newWord.append(ch)
          if(current.child(ch).isLeaf) {
            flag = true
            str.append(newWord).append(" ")
            j = word.length
          }
          current = current.child(ch)
        }
        else j = word.length
        j += 1
      }
      if(!flag) str.append(word).append(" ")
      i += 1
    }
    str.substring(0, str.length - 1).toString
  }
}
