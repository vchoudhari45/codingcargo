package com.vc.medium;

class L375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return solve(1, n, dp);
    }

    private int solve(int lo, int hi, int[][] dp) {
        if(lo >= hi) return 0;
        if(dp[lo][hi] > 0) return dp[lo][hi];
        int res = Integer.MAX_VALUE;
        for(int i = lo; i <= hi; i++) {
            res = Math.min(res, Math.max(i + solve(lo, i - 1, dp), i + solve(i + 1, hi, dp)));
        }
        dp[lo][hi] = res;
        return res;
    }
}
