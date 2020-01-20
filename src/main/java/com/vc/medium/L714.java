package com.vc.medium;

class L714 {
    public int maxProfit(int[] prices, int fee) {
        /**
         dp_i_k_0
         on ith day we can perform k transaction and we should have zero stock in our hand

         dp_i_k_1
         on ith day we can perform k transaction and we should have one stock in our hand
         */
        int dp_i_k_0 = 0;
        int dp_i_k_1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int dp_i_k_0_old = dp_i_k_0;

            //Rest or Sell on ith day, so that we will have zero stock in our hand
            dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);

            //Rest or Buy on ith day, so that we will have one stock in our hand
            dp_i_k_1 = Math.max(dp_i_k_1, dp_i_k_0_old - prices[i] - fee);

        }
        return dp_i_k_0;
    }
}
