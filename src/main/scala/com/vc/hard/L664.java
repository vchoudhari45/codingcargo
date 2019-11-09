package com.vc.hard;

class L664 {
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        /**
         (0, 0)
         (1, 1)
         (2, 2)

         (0, 1)
         (1, 2)

         (0, 2)
         */
        int k = 0;
        while(k < n) {
            int i = 0;
            int j = k;
            while(j < n) {
                if(i == j) dp[i][j] = 1;
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int l = i; l < j; l++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j]);
                    }
                    if(s.charAt(i) == s.charAt(j)) dp[i][j]--;
                }
                i++;
                j++;
            }
            k++;
        }
        return dp[0][n - 1];
    }
}
