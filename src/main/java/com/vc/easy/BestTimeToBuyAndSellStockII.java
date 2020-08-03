package com.vc.easy;

/*****
 *  Problem No: 122
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Dynamic Programming, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Best Time to Buy and Sell Stock II
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. Note that you cannot sell a stock before you buy one, It is an easy problem that uses Dynamic Programming to solve the problem.
 *  Description: Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. Note that you cannot sell a stock before you buy one.
 *  Input: [7,1,5,3,6,4]
 *  Output: 7
 *  Input: [7,6,4,3,1]
 *  Output: 0
 *  Similar Question: Best Time to Buy and Sell Stock I, Best Time to Buy and Sell Stock III, Best Time to Buy and Sell Stock IV, Best Time to Buy and Sell Stock with cool down
 *****/

class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        /**
             dp[i][k][0]
             Profit on ith Day, with k transaction in total we should have 0 stocks in our hand

             dp[i][k][1]
             Profit on ith Day, with k transaction in total we should have 1 stock in our hand

             only Buy action reduces number of transaction k

             in this case K = Infinity
         */
        int dp_i_k_0 = 0;
        int dp_i_k_1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int dp_i_k_0_old = dp_i_k_0;

            //Rest or Sell on ith day for us to have zero stock in our hand
            dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);

            //Rest or Buy on ith day for us to have one stock in our hand
            dp_i_k_1 = Math.max(dp_i_k_1, dp_i_k_0_old - prices[i]);
        }
        return dp_i_k_0;
    }
}
