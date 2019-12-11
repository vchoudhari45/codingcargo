package com.vc.hard;

class L72 {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int[][] dp = new int[w1 + 1][w2 + 1];
        for(int i = 0; i <= w1; i++) {
            for(int j = 0; j <= w2; j++) {
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[w1][w2];
    }
}
