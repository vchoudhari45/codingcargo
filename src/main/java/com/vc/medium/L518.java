package com.vc.medium;

class L518 {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;

        int n = coins.length;
        if(n == 0) return 0;

        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= amount; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else if(j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
                }
            }
        }
        return dp[n][amount];
    }
}
