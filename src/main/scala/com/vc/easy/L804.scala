package com.vc.easy

object L804 {
  def uniqueMorseRepresentations(words: Array[String]): Int = {
    val arr = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")

    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    val str = new mutable.StringBuilder()
    words.foreach(word => {
      word.foreach(ch => {
        val idx = ch - 'a'
        str.append(arr(idx))
      })
      set += str.toString
      str.clear
    })
    set.size
  }
}
