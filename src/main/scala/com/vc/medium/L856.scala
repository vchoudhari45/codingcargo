package com.vc.medium

object L856 {
  def scoreOfParentheses(S: String): Int = {
    var l = 0
    var res = 0
    (0 until S.length).foreach(i => {
      if(S(i) == '(') l += 1 else l -= 1
      if(S(i) == ')' && S(i - 1) == '(') res += 1 << l
    })
    res
  }
}
