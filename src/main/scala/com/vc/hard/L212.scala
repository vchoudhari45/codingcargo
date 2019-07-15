package com.vc.hard

object Solution {
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    import scala.collection.mutable
    val res = new mutable.HashSet[String]()

    case class Node(child: mutable.HashMap[Char, Node], var isLeaf: Boolean)
    class Trie {
      val root = new Node(new mutable.HashMap[Char, Node], false)
      def addWord(str: String): Unit = {
        var current = root
        str.indices.foreach(i => {
          val ch = str(i)
          if(!current.child.contains(ch)) {
            val node = new Node(new mutable.HashMap[Char, Node], false)
            current.child.put(ch, node)
          }
          current = current.child(ch)
        })
        current.isLeaf = true
      }

      def search(str: String): (Boolean, Boolean) = {
        var current = root
        str.indices.foreach(i => {
          val ch = str(i)
          if(!current.child.contains(ch)) return (false, false)
          current = current.child(ch)
        })
        (true, current.isLeaf)
      }
    }

    val n = board.length
    if(n == 0) return res.toList
    val m = board(0).length

    val visited = new mutable.HashSet[(Int, Int)]()
    val dirs =  Array((1, 0),(0, 1), (0, -1), (-1, 0))
    val trie = new Trie()
    def solve(x: Int, y: Int, str: String): Unit = {
      if(!visited.contains((x, y))) {
        visited += ((x, y))

        val searchRes = trie.search(str)
        if(!searchRes._1) {
          visited -= ((x, y))
          return
        }
        else if(searchRes._2) res += str

        dirs.foreach(dir => {
          val xNew = x + dir._1
          val yNew = y + dir._2
          if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m) {
            solve(xNew, yNew, str + board(xNew)(yNew))
          }
        })
        visited -= ((x, y))
      }
    }

    words.foreach(word => {
      trie.addWord(word)
    })
    board.indices.foreach(i => {
      board(i).indices.foreach(j => {
        visited.clear()
        solve(i, j, board(i)(j)+"")
      })
    })
    res.toList
  }
}
