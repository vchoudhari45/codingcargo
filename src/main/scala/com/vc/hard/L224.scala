package com.vc.hard

object L224 {
  def calculate(s: String): Int = {
    var res = 0
    var number = 0
    var sign = 1
    val n = s.length
    var i = 0
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    while(i < n) {
      val ch = s(i)
      if(Character.isDigit(ch)) {
        number = 0
        while(i < n && Character.isDigit(s(i))) {
          number = 10 * number + (s(i) - '0')
          i += 1
        }
        i -= 1
      }
      else if(ch == '+') {
        res += sign * number
        number = 0
        sign = 1
      }
      else if(ch == '-') {
        res += sign * number
        number = 0
        sign = -1
      }
      else if(ch == '(') {
        st.push(res)
        st.push(sign)
        res = 0
        sign = 1
      }
      else if(ch == ')') {
        res += sign * number
        res *= st.pop
        res += st.pop
        number = 0
      }
      i += 1
    }
    if(number != 0) res += sign * number
    res
  }
}