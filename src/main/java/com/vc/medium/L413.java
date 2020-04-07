package com.vc.medium;

class L413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;

        int n = A.length, total = 0;
        int[] dp = new int[n];
        for(int i = 2; i < n; i++) {
            if(A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                total += dp[i];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return total;
    }
}
