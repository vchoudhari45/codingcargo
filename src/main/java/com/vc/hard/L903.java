package com.vc.hard;

import java.util.*;

class L903 {
    public int numPermsDISequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int MOD = (int)1e9 + 7;
        Arrays.fill(dp[0], 1);
        for(int i = 0; i < n; i++) {
            int cur = 0;
            if(s.charAt(i) == 'I') {
                for(int j = 0; j < n - i; j++) {
                    cur = (cur + dp[i][j]) % MOD;
                    dp[i + 1][j] = cur;
                }
            }
            else {
                for(int j = n - i - 1; j >= 0; j--) {
                    cur = (cur + dp[i][j + 1]) % MOD;
                    dp[i + 1][j] = cur;
                }
            }
        }
        return dp[n][0];
    }
}