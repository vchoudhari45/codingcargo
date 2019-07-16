package com.vc.hard

class StreamChecker(words: Array[String]) {
  import scala.collection.mutable
  case class Node(child: mutable.HashMap[Char, Node], var isLeaf: Boolean)
  class Trie {
    val root = Node(new mutable.HashMap[Char, Node], false)
    def addWord(str: String): Unit = {
      var current = root
      str.foreach(ch => {
        if(!current.child.contains(ch)) {
          current.child.put(ch, Node(new mutable.HashMap[Char, Node](), false))
        }
        current = current.child(ch)
      })
      current.isLeaf = true
    }

    def search(str: String): Boolean = {
      var current = root
      str.foreach(ch => {
        if(current.child.contains(ch)) {
          if(current.child(ch).isLeaf) return true
          else current = current.child(ch)
        }
        else return false
      })
      false
    }
  }

  val trie = new Trie()
  words.foreach(word => trie.addWord(word.reverse))

  var str = ""
  def query(letter: Char): Boolean = {
    str = letter + str
    trie.search(str)
  }
}

/**
  * Your StreamChecker object will be instantiated and called as such:
  * var obj = new StreamChecker(words)
  * var param_1 = obj.query(letter)
  */
