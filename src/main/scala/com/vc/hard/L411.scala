package com.vc.hard

object L411 {
  def minAbbreviation(target: String, dictionary: Array[String]): String = {
    import scala.collection.mutable

    //Tries structure to store all the elements from dictionary
    case class Node(child: mutable.HashMap[Char, Node], var isWord: Boolean)
    val root = Node(new mutable.HashMap[Char, Node](), false)
    def add(root: Node, word: String): Unit = {
      var current = root
      word.foreach(ch => {
        if(!current.child.contains(ch)) {
          current.child.put(ch, new Node(new mutable.HashMap[Char, Node](), false))
        }
        current = current.child(ch)
      })
      current.isWord = true
    }
    def search(word: String, current: Node, num: Int): Boolean = {
      if(num > 0) {
        //Keep on skipping characters until num > 0
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
          //Word starts with number
          return search(word.substring(idx), current, numVar)
        }
        else {
          //Word start with characters
          val ch = word(0)
          if(current.child.contains(ch))
            return search(word.substring(1), current.child(ch), numVar)
          else
            return false
        }
      }
    }


    //Get abbreviation of given length for target word
    val sb = new mutable.StringBuilder()
    val list = new mutable.ListBuffer[String]()
    def getAbbr(currentIndex: Int, requiredLength: Int): Unit = {
      if(currentIndex >= target.length) return
      val prevNum = sb.nonEmpty && sb(sb.length - 1) >= '0' && sb(sb.length - 1) <= '9'

      if(requiredLength == 1) {
        if(currentIndex == target.length - 1) {
          sb.append(target(currentIndex))
          list += sb.toString
        }
        else if(!prevNum) {
          val remainingLengthFromTarget = target.length - currentIndex
          sb.append(remainingLengthFromTarget)
          list += sb.toString
        }
      }
      else {
        val endIndex = sb.length

        //Append letter
        sb.append(target(currentIndex))
        getAbbr(currentIndex + 1, requiredLength - 1)
        sb.delete(endIndex, sb.length)

        //Append number
        if(!prevNum) {
          (currentIndex + 1 until target.length).foreach(i => {
            sb.append(i - currentIndex)
            getAbbr(i, requiredLength - 1)
            sb.delete(endIndex, sb.length)
          })
        }
      }
    }

    //Add all elements from dict into tries for searching
    dictionary.foreach(word => {
      add(root, word)
    })

    //Start with index 1 & go until target.length
    (1 until target.length).foreach(i => {
      list.clear
      sb.clear
      getAbbr(0, i)
      println(list.mkString(", "))
      list.foreach(word => {
        if(!search(word, root, 0)) return word
      })
    })
    target
  }
}