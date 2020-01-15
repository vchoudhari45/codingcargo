package com.vc.medium;

class L279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++) dp[i] = i;
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
