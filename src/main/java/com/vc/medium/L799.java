package com.vc.medium;

class L799 {
    public double champagneTower(int poured, int query_row, int query_col) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for(int r = 1; r <= query_row; r++) {
            for(int c = 0; c < r; c++) {
                double q = (dp[r - 1][c] - 1) / 2.0;
                if(q > 0) {
                    dp[r][c] += q;
                    dp[r][c + 1] += q;
                }
            }
        }
        return Math.min(1, dp[query_row][query_col]);
    }
}
