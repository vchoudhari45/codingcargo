package com.vc.medium;

class L416 {
    public boolean canPartition(int[] arr) {
        int n = arr.length;

        int sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];

        if(sum % 2 != 0) return false;
        sum /= 2;

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        /**
               0 1 2 3 4
             0 T F F F F
             1 T T F F F
             2 T T T T F
             1 T T T T T
         */
        //if this is zero sum it is possible to make it with any subset
        for(int i = 0; i < dp.length; i++) dp[i][0] = true;

        for(int i = 1; i < dp.length; i++) {
            int num = arr[i - 1];
            for(int sumValue = 1; sumValue < dp[0].length; sumValue++) {
                if(num > sumValue) {
                    dp[i][sumValue] = dp[i - 1][sumValue];
                }
                else {
                    int remainingSum = sumValue - num;
                    dp[i][sumValue] = dp[i - 1][sumValue] || dp[i - 1][remainingSum];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
