package com.vc.hard;

class StrangePrinter {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];
        for(int len = 0; len < n; len++) {
            for(int from = 0; from + len < n; from++) {
                int to = from + len;
                if(len == 0) dp[from][to] = 1;
                else {
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int middle = from; middle < to; middle++) {
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][middle] + dp[middle + 1][to]);
                    }
                    if(s.charAt(from) == s.charAt(to)) dp[from][to]--;
                }
            }
        }
        return dp[0][n - 1];
    }
}