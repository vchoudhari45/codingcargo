package com.vc.hard;

import java.util.*;

class L1269 {
    int MOD = (int)1e9 + 7;
    public int numWays(int steps, int arrLen) {
        if(arrLen == 1) return 1;

        if(arrLen > steps) arrLen = steps;
        int[][] dp = new int[steps + 1][arrLen + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(steps, 0, arrLen, dp);
    }

    private int solve(int steps, int pos, int len, int[][] dp) {
        if(pos >= len || pos < 0) return 0;
        if(steps == 0) return pos == 0 ? 1 : 0;
        if(dp[steps][pos] != -1) return dp[steps][pos];

        long right = solve(steps - 1, pos + 1, len, dp) % MOD;  //right
        long left = solve(steps - 1, pos - 1, len, dp) % MOD;  //left
        long stay = solve(steps - 1, pos, len, dp) % MOD;      //stay

        dp[steps][pos] = (int)((right + left + stay) % MOD);
        return dp[steps][pos];
    }
}
