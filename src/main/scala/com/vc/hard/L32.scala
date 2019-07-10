package com.vc.hard

object L32 {
  def longestValidParentheses(s: String): Int = {
    val n = s.length
    val dp = new Array[Int](n)
    var res = Int.MinValue
    s.indices.foreach(i => {
      val ch = s(i)
      if(ch == ')'){
        // Add valid substring length before current running valid string
        // For e.g. ()()() and we are at index = 5
        // Here current running valid string is from index 4 to 5 which is ()
        // But already existing valid string is from 0 to 3
        // and dp array state will be [0, 2, 0, 4, 0, (4 + 2)]
        // So basically we are adding 2 to already found 4 valid brackets here only if i - 2 >= 0
        if(i > 0 && s(i - 1) == '(')
          dp(i) = (if(i - 2 >= 0) dp(i - 2) else 0) + 2
        else if(i > 0 && i - dp(i - 1) > 0 && s(i - dp(i - 1) - 1) == '('){
          //This happens when we have (())
          //in this case dp array will [0, 0, 2, ?]
          //Since last closing bracket can be matched with first
          //How do we know? We remove matching length from previous index from current index
          //For e.g matching length from previous index here is 2
          //current index is 3
          //3(Current Index) - 2(Matching Length until Previous Index) - 1(Character before matched index)
          //If that character is '(' then we have another match
          //dp(i - dp(i - 1) - 2) to see if there was some valid string before '(' for e.g. ()(())
          //dp array will be [0, 2, 0, 0, 2, ?]
          //dp(i - 1) = 2
          //dp(i - d(i - 1) - 2) = 2
          //plus 2 because matching current ')'
          dp(i) = dp(i - 1) + (if(i - dp(i - 1) >= 2) dp(i - dp(i - 1) - 2) else 0) + 2
        }
      }
      res = Math.max(res, dp(i))
    })
    if(res == Int.MinValue) 0 else res
  }
}
