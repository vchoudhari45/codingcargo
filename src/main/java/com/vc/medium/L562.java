package com.vc.medium;

class L562 {
    public int longestLine(int[][] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        int m = arr[0].length;

        int[][][] dp = new int[n + 2][m + 2][4];
        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr[i - 1][j - 1] == 1) {
                    //Row
                    dp[i][j][0] = dp[i - 1][j][0] + 1;

                    //Col
                    dp[i][j][1] = dp[i][j - 1][1] + 1;

                    //Diagonal
                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1;

                    //Anti-Diagonal
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;

                    max = Math.max(dp[i][j][0], max);
                    max = Math.max(dp[i][j][1], max);
                    max = Math.max(dp[i][j][2], max);
                    max = Math.max(dp[i][j][3], max);
                }
            }
        }
        return max;
    }
}
