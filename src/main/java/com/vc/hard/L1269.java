package com.vc.hard;

import java.util.*;

class L1269 {
    int[][] memo;
    int MOD = (int)1e9 + 7;
    public int numWays(int steps, int arrLen) {
        if(arrLen > steps) arrLen = steps;
        this.memo = new int[steps + 1][arrLen + 1];
        for(int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);
        return solve(steps, 0, arrLen);
    }

    private int solve(int steps, int index, int arrLen) {
        if(index >= arrLen || index < 0) return 0;
        if(steps == 0) return index == 0 ? 1 : 0;
        if(memo[steps][index] != -1) return memo[steps][index];

        long left = solve(steps - 1, index - 1, arrLen) % MOD;
        long right = solve(steps - 1, index + 1, arrLen) % MOD;
        long stay = solve(steps - 1, index , arrLen) % MOD;

        memo[steps][index] = (int)((left + right + stay) % MOD);
        return memo[steps][index];
    }
}
