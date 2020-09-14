package com.vc.hard;

class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                }
                else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                }
                else {
                    char requiredChar = s3.charAt(i + j - 1);
                    dp[i][j] = dp[i - 1][j] && requiredChar == s1.charAt(i - 1);
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && requiredChar == s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}