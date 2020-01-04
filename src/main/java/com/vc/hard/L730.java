package com.vc.hard;

class L730 {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int MOD = (int)1e9 + 7;
        /**
                     0 1 2 3
                     b c c b
                 0 b 1 2 3 6
                 1 c   1 2 3
                 2 c     1 2
                 3 b       1
         */
        for(int len = 0; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(i == j) dp[i][j] = 1;
                else {
                    if(s.charAt(i) == s.charAt(j)) {

                        //Middle palindrome count will be doubled as character at i & j are same
                        //For e.g. aba
                        //middle palindrome count dp(i + 1)(j - 1) = 1  {b}
                        //Since character at i & j are same aba is also palindrome so {b, aba}
                        dp[i][j] += dp[i + 1][j - 1] * 2;

                        //Plus palindrome with character at i & j
                        dp[i][j] += 2;


                        //Now comes the part to eliminate the duplicates
                        //and that happens when you have same characters in the middle palindrome
                        //We try to find the boundry of character which are same as character at i

                        //For e.g. ababa
                        //         01234
                        //low will be  2 after running whiles loops
                        //high will be 2 after running whiles loops
                        int low = i + 1;
                        int high = j - 1;

                        while(low <= high && s.charAt(low) != s.charAt(j)) {
                            low++;
                        }

                        while(low <= high && s.charAt(high) != s.charAt(j)) {
                            high--;
                        }

                        //Case 1 there is only 1 character in middle palindrome ababa
                        //Here we already have {a} from middle palindrome so remove that
                        if(low == high) dp[i][j] -= 1;

                            //Case 2 there are no characters in middle palindrome aba
                        else if(low > high) dp[i][j] += 0;

                            //Case 3 there are 2 or more than 2 characters in middle palindrome abaaaba
                            //So here we remove all the palindrome from "aaa" + remove {a, aa}
                        else {
                            dp[i][j] -= 2;
                            dp[i][j] -= dp[low + 1][high - 1];
                        }
                    }
                    else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j] + MOD : dp[i][j] % MOD;
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}
