package com.vc.medium;

class L416 {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        if(sum % 2 != 0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : arr) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];
    }
}
