package com.vc.hard;

import java.util.*;

class L123 {
    public int maxProfit(int[] prices) {
        /**
             Input:
             [3 3 5 0 0 3 1 4]
             1 2 3 4 5 6 7 8

             k = 2
             Number of transactions allowed is 2, which means 2 Buys and 2 Sells are allowed

             Explanation:
             dp_i_0[k] -> Profit on ith day after k transaction and zero stock in hand at end of day
             dp_i_1[k] -> Profit on ith day after k transactions and one stock in hand at end of day


             Formula:
             dp_i_1[j] = Math.max(dp_i_1[j], dp_i_0[j - 1] - prices[i])
             -> On ith Day we can either do nothing which gives us dp_i_1[j] profit
             -> Or Perform buy which gives us dp_i_0[j - 1] - prices[i]
             -> dp_i_0[j - 1] because we buy stock with profit made until previous transaction
             and previous transaction has to be sell because we can't buy again before we sell
             -> - prices[i]   because we buy with current days price


             dp_i_0[j] = Math.max(dp_i_0[j], dp_i_1[j] + prices[i])
             -> On ith Day we can either do nothing which gives us dp_i_0[j] profit
             -> Or Perform sell which gives us dp_i_1[j] + prices[i]
             -> dp_i_1[j]    because we sell stock which was bought at 1st best price
             -> + prices[i]  because we get profit after selling stock

             0th Day
             dp_i_1 [-I, -I, -I]
             dp_i_0 [0,   0,  0]

             1st Day = 3
             dp_i_1 [-I, -3, -3]
             dp_i_0 [ 0,  0,  0]

             2nd Day = 3
             dp_i_1 [-I, -3, -3]
             dp_i_0 [ 0,  0,  0]

             3rd Day = 5
             dp_i_1 [-I, -3, -3]
             dp_i_0 [ 0,  2,  2]

             4th Day = 0
             dp_i_1 [-I,  0,  2]
             dp_i_0 [ 0,  2,  2]

             5th Day = 0
             dp_i_1 [-I,  0,  2]
             dp_i_0 [ 0,  2,  2]

             6th Day = 3
             dp_i_1 [-I,  0,  2]
             dp_i_0 [ 0,  3,  5]

             7th Day = 1
             dp_i_1 [-I,  0,  2]
             dp_i_0 [ 0,  3,  5]


             8th Day = 4
             dp_i_1 [-I,  0,  2]
             dp_i_0 [ 0,  4,  6]
         */
        int n = prices.length;
        if(n <= 1) return 0;

        int[] dp_i_0 = new int[3];
        int[] dp_i_1 = new int[3];
        Arrays.fill(dp_i_1, Integer.MIN_VALUE);

        for(int i = 0; i < prices.length; i++) {
            for(int j = 1; j <= 2; j++) {
                //Rest or Sell on ith Day
                dp_i_0[j] = Math.max(dp_i_0[j], dp_i_1[j] + prices[i]);

                //Rest or Buy on ith Day, When we Buy number of transaction reduces by 1
                dp_i_1[j] = Math.max(dp_i_1[j], dp_i_0[j - 1] - prices[i]);
            }
        }
        return dp_i_0[2];
    }
}