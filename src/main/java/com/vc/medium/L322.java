package com.vc.medium;

import java.util.*;

class L322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if(j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
