package com.vc.hard;

class L1289 {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) dp[i][j] = arr[i][j];
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int row = 1; row < n; row++) {
            for(int col = 0; col < m; col++) {
                for(int c = 0; c < m; c++) {
                    if(col != c) {
                        dp[row][col] = Math.min(dp[row][col], dp[row - 1][c] + arr[row][col]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int col = 0; col < m; col++) {
            res = Math.min(res, dp[n - 1][col]);
        }

        return res;
    }
}
