package com.vc.medium;

import java.util.Arrays;

class L279 {
    public int numSquares(int n) {
        //first try to find the solution for 1
        if(n == 0 || n == 1) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int number = 2; number <= n; number++) {
            for(int square = 1; square <= n; square++) {
                if(number < square * square) break;

                int remaining = number - (square * square);
                dp[number] = Math.min(dp[number], 1 + dp[remaining]);
            }
        }
        return dp[n];
    }
}