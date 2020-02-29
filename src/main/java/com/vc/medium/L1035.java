package com.vc.medium;

import java.util.Arrays;

class L1035 {

    private int[][] dp;

    public int maxUncrossedLines(int[] A, int[] B) {
        this.dp = new int[A.length + 1][B.length + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(A, 0, B, 0);
    }

    private int solve(int[] A, int a, int[] B, int b) {
        if(a >= A.length || b >= B.length) return 0;

        if(dp[a][b] != -1) return dp[a][b];

        int res = 0;
        if(A[a] == B[b]) res = 1 + solve(A, a + 1, B, b + 1);
        else res = Math.max(solve(A, a + 1, B, b), solve(A, a, B, b + 1));

        dp[a][b] = res;
        return dp[a][b];
    }
}
