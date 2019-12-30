package com.vc.hard;

class L664 {
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int len = 0; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                    if(s.charAt(i) == s.charAt(j)) dp[i][j]--;
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%4d", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}