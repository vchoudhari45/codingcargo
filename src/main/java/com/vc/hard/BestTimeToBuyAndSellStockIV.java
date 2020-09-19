package com.vc.hard;

import java.util.*;

class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        if(2 * k >= n) {// i.e. we can perform unlimited number of transactions
            int dp_i_k_0 = 0;
            int dp_i_k_1 = Integer.MIN_VALUE;
            for(int i = 0; i < prices.length; i++) {
                int dp_i_k_0_old = dp_i_k_0;
                //Rest or Sell on given Day
                dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);

                //Rest or Buy on given Day
                dp_i_k_1 = Math.max(dp_i_k_1, dp_i_k_0_old - prices[i]);
            }
            return dp_i_k_0;
        }

        /**
             Ideally logic below should be enough for this problem but since very large value of K gives us Memory Limit Exceeded exception, so we need logic above

             If value of K larger than prices.length / 2 then we know for sure that we are allowed to do unlimited number of transaction, because on a given day we can either Buy, Rest or Sell.


             dp_i_0[k]
             on ith day, we can perform k at most transaction and we should have zero stock left in our hand

             dp_i_1[k]
             on ith day, we can perform k at most transaction and we should have one stock left in our hand
         */

        int[] dp_i_0 = new int[k + 1];
        int[] dp_i_1 = new int[k + 1];
        Arrays.fill(dp_i_1, Integer.MIN_VALUE);
        for(int i = 0; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                //Rest or Sell so that we should have zero stock in our hand
                dp_i_0[j] = Math.max(dp_i_0[j], dp_i_1[j] + prices[i]);

                //Rest or Buy so that we should have one stock in our hand
                dp_i_1[j] = Math.max(dp_i_1[j], dp_i_0[j - 1] - prices[i]);
            }
        }
        return dp_i_0[k];
    }
}