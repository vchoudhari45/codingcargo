package com.vc.hard;

class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        /**
               0  r  a  b  b  i  t
             0 1, 0, 0, 0, 0, 0, 0
             r 1, 1, 0, 0, 0, 0, 0
             a 1, 1, 1, 0, 0, 0, 0
             b 1, 1, 1, 1, 0, 0, 0
             b 1, 1, 1, 2, 1, 0, 0
             b 1, 1, 1, 3, 3, 0, 0
             i 1, 1, 1, 3, 3, 3, 0
             t 1, 1, 1, 3, 3, 3, 3
         */
        int sn = s.length();
        int tn = t.length();
        int[][] dp = new int[sn + 1][tn + 1];
        for(int i = 0; i <= sn; i++) {
            for(int j = 0; j <= tn; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) {
                    dp[i][j] = 0;
                }
                else if(j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                    if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[sn][tn];
    }
}
