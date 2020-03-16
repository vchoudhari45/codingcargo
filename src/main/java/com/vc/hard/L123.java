package com.vc.hard;

import java.util.*;

class L123 {
    public int maxProfit(int[] prices) {
        /**
             dp[i][0][K]
             On ith day with K transaction in total we should have zero stock left in our hand

             dp[i][1][K]
             On ith day with K transaction in total we should have one stock left in our hand
         */
        int n = prices.length;
        if(n <= 1) return 0;

        int[] dp_i_0 = new int[3];
        int[] dp_i_1 = new int[3];
        Arrays.fill(dp_i_1, Integer.MIN_VALUE);

        for(int i = 0; i < prices.length; i++) {
            for(int j = 2; j > 0; j--) {
                //Rest or Sell on ith Day
                dp_i_0[j] = Math.max(dp_i_0[j], dp_i_1[j] + prices[i]);

                //Rest or Buy on ith Day, When we Buy number of transaction reduces by 1
                dp_i_1[j] = Math.max(dp_i_1[j], dp_i_0[j - 1] - prices[i]);
            }
        }
        return dp_i_0[2];
    }
}