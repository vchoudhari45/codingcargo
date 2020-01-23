package com.vc.medium;

class L474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str: strs) {
            int[] count = count(str);
            for(int i = m; i >= count[0]; i--) {
                for(int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int ones = 0, zeros = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') zeros++;
            else ones++;
        }
        return new int[]{zeros, ones};
    }
}
