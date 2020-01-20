package com.vc.medium;

class L309 {
    public int maxProfit(int[] prices) {
        /**
             dp_i_k_0
             On ith day, we can perform k transaction and we should have zero stock left in our hand

             dp_i_k_1
             On ith day, we can perform k transaction and we should have one stock left in our hand

             Since we need cooldown we need another variable called dp_i_k_pre which is buy value 1 day before
         */
        int dp_i_k_0 = 0;
        int dp_i_k_pre = 0;
        int dp_i_k_1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int dp_i_k_0_old = dp_i_k_0;

            //Rest or Sell stock, so that we should have 0 stock in our hand
            dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);

            //Rest or Buy Stock, so that we should have 1 stock in our hand
            dp_i_k_1 = Math.max(dp_i_k_1, dp_i_k_pre - prices[i]);

            dp_i_k_pre = dp_i_k_0_old;
        }
        return dp_i_k_0;
    }
}
