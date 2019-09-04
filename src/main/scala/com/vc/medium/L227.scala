package com.vc.medium

object L227 {
  def calculate(s: String): Int = {
    val n = s.length
    var i = 0
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    var num = 0
    while(i < n) {
      val ch = s(i)
      if(Character.isDigit(ch)) {
        num = num * 10 + (ch - '0')
      }
      else if(ch == '+') {
        st.push(num)
        num = 0
      }
      else if(ch == '-') {
        st.push(-1 * num)
        num = 0
      }
      else if(ch == '*') {
        st.push(st.pop * num)
        num = 0
      }
      else if(ch == '/') {
        st.push(st.pop / num)
      }
      i += 1
    }
    var res = 0
    while(st.nonEmpty) {
      res += st.pop
    }
    res
  }

  def main(args: Array[String]): Unit = {
    calculate("3+2*2")
  }
}
