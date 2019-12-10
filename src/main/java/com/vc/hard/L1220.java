package com.vc.hard;

class L1220 {
    public int countVowelPermutation(int n) {
        /**
         0 a -> {1}
         1 e -> {0, 2}
         2 i -> {0, 1, 3, 4}
         3 o -> {2, 4}
         4 u -> {0}
         */
        final int MOD = 1000000007;
        int[][] dirs = {{1, 2, 4}, {0, 2}, {1, 3}, {2}, {2, 3}};
        int[][] dp = new int[n][5];
        for(int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                for(int dir: dirs[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][dir]) % MOD;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 5; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }
        return res % MOD;
    }
}
