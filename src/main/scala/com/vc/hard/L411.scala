package com.vc.hard

object L411 {
  def minAbbreviation(target: String, dictionary: Array[String]): String = {
    import scala.collection.mutable

    //Trie logic for all dictionary words
    case class Node(child: mutable.HashMap[Char, Node], var isWord: Boolean)
    val root = Node(new mutable.HashMap[Char, Node], false)
    def add(root: Node, word: String): Unit = {
      var current = root
      word.foreach(ch => {
        if(!current.child.contains(ch)) {
          current.child.put(ch, Node(new mutable.HashMap[Char, Node](), isWord = false))
        }
        current = current.child(ch)
      })
      current.isWord = true
    }
    def search(word: String, current: Node, num: Int): Boolean = {
      if(num > 0) {
        current.child.foreach(x => {
          if(search(word, x._2, num - 1)) return true
        })
        return false
      }
      else {
        if(word.length == 0) return current.isWord
        var idx = 0
        var numVar = num
        while(idx < word.length && word(idx) >= '0' && word(idx) <= '9') {
          numVar = numVar * 10 + word(idx) - '0'
          idx += 1
        }
        if(idx != 0) {
          return search(word.substring(idx), current, numVar)
        }
        else {
          val ch = word(0)
          if(current.child.contains(ch))
            return search(word.substring(1), current.child(ch), num)
          else
            return false
        }
      }
    }

    //Add all the dictionary words into tries
    dictionary.foreach(word => {
      add(root, word)
    })

    //Get all the abbreviation of given length
    val list = new mutable.ListBuffer[String]()
    val abbr = new mutable.StringBuilder()
    def getAbbr(idx: Int, len: Int): Unit = {
      if(idx >= target.length) return
      val prevNum = abbr.length > 0 && abbr(abbr.length - 1) >= '0' && abbr(abbr.length - 1) <= '9'
      if(len == 1) {
        if(idx == target.length - 1) {
          abbr.append(target(idx))
          list += abbr.toString
        }
        else if(!prevNum) {
          val num = target.length - idx
          abbr.append(num.toString)
          list += abbr.toString
        }
      }
      else {
        val endIdx = abbr.length

        //Append character and go into recursion, backtrack to delete appended characters
        abbr.append(target(idx))
        getAbbr(idx + 1, len - 1)
        abbr.delete(endIdx, abbr.length)

        //Append number and go into recursion, backtrack to delete appended characters
        if(!prevNum) {
          (idx + 1 until target.length).foreach(i => {
            abbr.append(i - idx)
            getAbbr(i, len - 1)
            abbr.delete(endIdx, abbr.length)
          })
        }
      }
    }

    (1 until target.length).foreach(i => {
      abbr.clear
      list.clear
      getAbbr(0, i)
      list.foreach(abbr => {
        if(!search(abbr, root, 0)) return abbr
      })
    })
    target
  }
}