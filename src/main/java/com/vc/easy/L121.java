package com.vc.easy;

class L121 {
    public int maxProfit(int[] prices) {
        /**
             dp[i][k][0]
             Profit on ith Day, with k transaction in total we should have 0 stocks in our hand

             dp[i][k][1]
             Profit on ith Day, with k transaction in total we should have 1 stock in our hand

             only Buy action reduces number of transaction k

             in this case K = 1
         */
        int dp_i_k_0 = 0;
        int dp_i_k_1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            //Rest or Sell on ith day for us to have zero stock in our hand
            dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);

            //Rest or Buy on ith day for us to have one stock in our hand
            dp_i_k_1 = Math.max(dp_i_k_1, -prices[i]);
        }
        return dp_i_k_0;
    }
}
