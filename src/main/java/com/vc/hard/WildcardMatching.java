package com.vc.hard;

class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        else if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int si = 0; si <= m; si++) {
            for(int pi = 0; pi <= n; pi++) {
                if(si == 0 && pi == 0) dp[si][pi] = true;
                else if(si == 0) {
                    if(p.charAt(pi - 1) == '*') dp[si][pi] = dp[si][pi - 1];
                }
                else if(pi == 0) {
                    dp[si][pi] = false;
                }
                else {
                    if(p.charAt(pi - 1) == '*')
                        dp[si][pi] = dp[si][pi - 1] || dp[si - 1][pi];
                    else if(p.charAt(pi - 1) == '?' || p.charAt(pi - 1) == s.charAt(si - 1))
                        dp[si][pi] = dp[si - 1][pi - 1];
                }
            }
        }
        return dp[m][n];
    }
}