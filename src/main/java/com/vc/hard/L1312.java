package com.vc.hard;

import java.util.Arrays;

class L1312 {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(s, 0, s.length() - 1, dp);
    }

    private int solve(String s, int start, int end, int[][] dp) {
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int steps = 0;
        if(s.charAt(start) == s.charAt(end)) {
            steps = solve(s, start + 1, end - 1, dp);
        }
        else {
            steps = 1 + Math.min(solve(s, start + 1, end, dp), solve(s, start, end - 1, dp));
        }
        dp[start][end] = steps;
        return steps;
    }
}
