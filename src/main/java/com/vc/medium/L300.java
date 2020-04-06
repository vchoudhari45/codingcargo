package com.vc.medium;

import java.util.Arrays;

class L300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
