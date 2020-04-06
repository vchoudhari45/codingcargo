package com.vc.medium;

import java.util.Arrays;

class L279 {
    public int numSquares(int n) {
        //first try to find the solution for 1
        if(n == 0 || n == 1) return n;

        int squareCount = (int)(Math.sqrt(n)) + 1;
        int[] squares = new int[squareCount];
        for(int i = 0; i < squareCount; i++) {
            squares[i] = i * i;
        }
        //System.out.println(Arrays.toString(squares));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < squareCount; j++) {
                if(i < squares[j]) break;

                //consider square[j] as one of the value
                int remaining = i - squares[j];
                dp[i] = Math.min(dp[i], 1 + dp[remaining]);
            }
        }
        return dp[n];
    }
}