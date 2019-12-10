package com.vc.easy

object L67 {
  def addBinary(a: String, b: String): String = {
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    import scala.collection.mutable
    val s = new mutable.Stack[Int]()
    while(i >= 0 && j >= 0) {
      val t = add(a(i), b(j), carry)
      carry = t._1
      s.push(t._2)
      i -= 1
      j -= 1
    }
    while(i >= 0) {
      val t = add(a(i), '0', carry)
      carry = t._1
      s.push(t._2)
      i -= 1
    }
    while(j >= 0) {
      val t = add('0', b(j), carry)
      carry = t._1
      s.push(t._2)
      j -= 1
    }
    if(carry == 1) s.push(carry)
    s.mkString("")
  }

  def add(c1:Char, c2:Char, carry: Int): (Int, Int) = {
    val c1Int = c1.toInt - '0'
    val c2Int = c2.toInt - '0'
    val sum = c1Int + c2Int + carry
    (sum / 2, sum % 2)
  }
}
