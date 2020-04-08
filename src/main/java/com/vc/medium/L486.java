package com.vc.medium;

class L486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return true;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int l = 0; l < n; l++) {
            for(int from = 0; from + l < n; from++) {
                int to = from + l;

                if(l == 0) {
                    //Only one element first player will choose that element and wins
                    dp[from][to] = nums[from];
                }
                else if(l == 1) {
                    //Only two elements first player will choose max element and wins
                    dp[from][to] = Math.max(nums[from], nums[to]);
                }
                else {
                    dp[from][to] = Math.max(nums[from] - dp[from + 1][to], nums[to] - dp[from][to - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
