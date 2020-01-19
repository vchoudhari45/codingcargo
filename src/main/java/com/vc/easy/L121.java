package com.vc.easy;

class L121 {
    public int maxProfit(int[] prices) {
        /**
             dp[i][k][0]
             on ith Day, we can do k transactions and we will end up having 0 stock in our hand

             dp[i][k][1]
             on ith Day, we can do k transactions and we will end up having 1 stock in our hand
         */
        int n = prices.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][2];
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];

            //Rest Or Sell action, because at the end of ith day we need zero stock in our hand
            dp[i][0] = i == 0 ? 0 : Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);

            //Buy, because at the end of ith day we need one stock in our hand
            //Equation becomes dp[i][1] = i == 0 ? - prices[i] : Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            //But since in this problem we are only allowed to do one transaction on all the given days equation becomes
            dp[i][1] = i == 0 ? - prices[i] : Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }
}
