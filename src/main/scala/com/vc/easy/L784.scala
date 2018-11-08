package com.vc.easy

import scala.collection.mutable

object L784 {
  def letterCasePermutation(s: String): List[String] = {
    var i = 0
    var j = 0
    var k = 0
    var n = 0
    val list = new mutable.ListBuffer[String]()
    val str = new mutable.StringBuilder()
    s.foreach(x => if(!Character.isDigit(x)) n += 1)
    while(i < (1 << n)) {
      j = 0
      k = 0
      while(j < s.length) {
        if(!Character.isDigit(s(j))) {
          if(((i >> k) & 1) == 1) str.append(s(j).toUpper)
          else str.append(s(j).toLower)
          k += 1
        }
        else str.append(s(j))
        j += 1
      }
      list += str.toString
      str.clear
      i += 1
    }
    list.toList
  }
}
