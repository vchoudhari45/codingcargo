package com.vc.medium;

class L343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        /**
             n = 6
             MaxMultiplication:  0 1 2 3 4 6 9
             Numbers:            0 1 2 3 4 5 6
         */
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                //User number itself or it's division
                int first = Math.max(j, dp[j]);
                int second = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], first * second);
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}