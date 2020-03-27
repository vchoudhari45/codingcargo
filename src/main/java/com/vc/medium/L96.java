package com.vc.medium;

class L96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int elements = 2; elements <= n; elements++) { // consider total number of elements
            for(int selectedRoot = 1; selectedRoot <= elements; selectedRoot++) {
                //For those elements select a root from 1 to elements
                int left = dp[selectedRoot - 1];
                int right = dp[elements - selectedRoot];
                dp[elements] += left * right;
            }
        }
        return dp[n];
    }
}