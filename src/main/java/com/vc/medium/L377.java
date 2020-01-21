package com.vc.medium;

import java.util.*;

class L377 {
    public int combinationSum4(int[] arr, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(arr, target, dp);
    }

    private int solve(int[] arr, int target, int[] dp) {
        if(target < 0) return 0;
        else if(dp[target] != -1) return dp[target];
        else if(target == 0) return 1;
        else {
            int res = 0;
            for(int i = 0; i < arr.length; i++) {
                int count = solve(arr, target - arr[i], dp);
                res += count;
            }
            dp[target] = res;
            return res;
        }
    }
}
