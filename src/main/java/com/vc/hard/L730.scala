package com.vc.hard

object L730 {
  def countPalindromicSubsequences(S: String): Int = {
    /**
    0 1 2 3
                  b c c b
              0 b 1 2 3 6
              1 c   1 2 3
              2 c     1 2
              3 b       1
      */

    val n = S.length
    val dp = Array.ofDim[Int](n, n)
    (0 until n).foreach(len => {
      (0 until n - len).foreach(i => {
        val j = i + len
        if(i == j) dp(i)(i) = 1
        else {
          if(S(i) == S(j)) {
            //Middle palindrome count will be doubled as character at i & j are same
            //For e.g. aba
            //middle palindrome count dp(i + 1)(j - 1) = 1  {b}
            //Since character at i & j are same aba is also palindrome so {b, aba}
            dp(i)(j) += dp(i + 1)(j - 1) * 2

            //Plus palindrome with character at i & j
            dp(i)(j) += 2

            //Now comes the part to eliminate the duplicates
            //and that happens when you have same characters in the middle palindrome
            //We try to find the boundry of character which are same as character at i

            //For e.g. ababa
            //         01234
            //low will be  2 after running whiles loops
            //high will be 2 after running whiles loops

            var low = i + 1     //Low boundary of character which is same as character at i
            var high = j - 1    //High boundary of character which is same as character at j

            while(low <= high && S(low) != S(j)) {
              low += 1
            }

            while(low <= high && S(high) != S(j)) {
              high -= 1
            }

            //Case 1 there is only 1 character in middle palindrome ababa
            //Here we already have {a} from middle palindrome so remove that
            if(low == high) dp(i)(j) -= 1

            //Case 2 there are no characters in middle palindrome aba
            else if(low > high) dp(i)(j) += 0

            //Case 3 there are 2 or more than 2 characters in middle palindrome abaaaba
            //So here we remove all the palindrome from "aaa" + remove {a, aa}
            else {
              dp(i)(j) -= dp(low + 1)(high - 1)
              dp(i)(j) -= 2
            }

          }
          else {
            dp(i)(j) = dp(i + 1)(j) + dp(i)(j - 1) - dp(i + 1)(j - 1)
          }
          dp(i)(j) = if(dp(i)(j) < 0) dp(i)(j) + 1000000007 else dp(i)(j) % 1000000007
        }
      })
    })
    dp(0)(n - 1)
  }
}