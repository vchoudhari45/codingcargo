package com.vc.medium;

class L516 {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];
        for(int l = 0; l < s.length(); l++) {
            for(int from = 0; from + l < s.length(); from++) {
                int to = from + l;
                if(l == 0) dp[from][to] = 1;
                else {
                    if(s.charAt(from) == s.charAt(to)) {
                        dp[from][to] = 2 + dp[from + 1][to - 1];
                    }
                    else {
                        dp[from][to] = Math.max(dp[from + 1][to], dp[from][to - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
