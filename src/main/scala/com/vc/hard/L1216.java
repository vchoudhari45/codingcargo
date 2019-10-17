package com.vc.hard;

class L1216 {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        String sReverse = str.reverse().toString();
        int lcsValue = lcs(s, sReverse);
        System.out.println(s.length() - lcsValue);
        return s.length() - lcsValue <= k;
    }

    private int lcs(String s, String reverse) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(s.charAt(i - 1) == reverse.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else if(s.charAt(i - 1) != reverse.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}