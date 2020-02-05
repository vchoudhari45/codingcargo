package com.vc.hard;

import java.util.Arrays;

class L1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = solve(arr, i, d, dp);
            max = Math.max(max, dp[i]);
        }

        return max + 1;
    }


    private int solve(int[] arr, int from, int d, int[] dp) {
        if(dp[from] != -1) return dp[from];

        int res = 0;
        //right
        int right = from + 1;
        while(right <= Math.min(from + d, arr.length - 1) && arr[from] > arr[right]) {
            res = Math.max(res, 1 + solve(arr, right, d, dp));
            right++;
        }

        //left
        int left = from - 1;
        while(left >= Math.max(from - d, 0) && arr[from] > arr[left]) {
            res = Math.max(res, 1 + solve(arr, left, d, dp));
            left--;
        }

        dp[from] = res;
        return res;
    }
}
