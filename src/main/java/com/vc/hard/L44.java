package com.vc.hard;

class L44 {
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        for(int i = 0; i <= sn; i++) {
            for(int j = 0; j <= pn; j++) {
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(j == 0) dp[i][j] = false;
                else if(i == 0 && p.charAt(j - 1) == '*') dp[i][j] = dp[i][j - 1];
                else if(i == 0) dp[i][j] = false;
                else if(p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                else if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[sn][pn];
    }
}
