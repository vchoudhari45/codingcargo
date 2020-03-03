package com.vc.medium;

class L718 {
    public int findLength(int[] A, int[] B) {
        if(A == null||B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        /**
             0 1 2 3 2 1
             0 0 0 0 0 0 0
             3 0 0 0 1 0 0
             2 0 0 1 0 2 0
             1 0 1 0 0 0 3
             4 0 0 0 0 0 0
             7 0 0 0 0 0 0
         */
        for(int i = 0; i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(A[i - 1] == B[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
