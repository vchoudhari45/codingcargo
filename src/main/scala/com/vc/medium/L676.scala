package com.vc.medium

/**Tries Problem */
object MagicDictionary{

  /** Initialize your data structure here. */
  import scala.collection.mutable
  case class Node(child: mutable.HashMap[Char, Node] = new mutable.HashMap[Char, Node], var isLeaf: Boolean = false)
  val root = Node()

  /** Build a dictionary through a list of words */
  def buildDict(dict: Array[String]): Unit = {
    dict.foreach(word => {
      var current = root
      word.foreach(ch => {
        if(!current.child.contains(ch)) {
          current.child.put(ch, Node())
        }
        current = current.child(ch)
      })
      current.isLeaf = true
    })
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  def search(word: String): Boolean = {
    def solve(index: Int, root: Node, flag: Boolean): Boolean = {
      if(index < word.length) {
        val ch = word(index)
        if(root.child.contains(ch)) {
          if(solve(index + 1, root.child(ch), flag)) return true
        }
        if(!flag) {
          root.child.foreach(eachChild => {
            if(eachChild._1 != ch && solve(index + 1, eachChild._2, true)) return true
          })
        }
        return false
      }
      flag && root.isLeaf
    }
    solve(0, root, flag = false)
  }

}

