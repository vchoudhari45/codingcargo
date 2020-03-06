package com.vc.hard;

class L44 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        for(int si = 0; si <= n; si++) {
            for(int pi = 0; pi <= m; pi++) {
                if(si == 0 && pi == 0) dp[si][pi] = true;
                else if(si == 0) {
                    if(p.charAt(pi - 1) == '*') {
                        dp[si][pi] = dp[si][pi - 1];
                    }
                }
                else if(pi == 0) {
                    dp[si][pi] = false;
                }
                else {
                    if(p.charAt(pi - 1) == '*') {
                        dp[si][pi] = dp[si][pi - 1] || dp[si - 1][pi];
                    }
                    else if(p.charAt(pi - 1) == '?' || p.charAt(pi - 1) == s.charAt(si - 1)) {
                        dp[si][pi] = dp[si - 1][pi - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}