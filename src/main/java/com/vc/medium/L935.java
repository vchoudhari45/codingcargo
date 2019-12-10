package com.vc.medium;

class L935 {
    public int knightDialer(int N) {
        int[][] dirs = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {0, 3, 9},
                {},
                {0, 1, 7},
                {2, 6},
                {1, 3},
                {2, 4},
        };

        final int MOD = 1000000007;
        int[][] dp = new int[N][10];
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int dir: dirs[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][dir]) % MOD;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 10; i++) {
            res = (res + dp[N - 1][i]) % MOD;
        }
        return res % MOD;
    }
}
