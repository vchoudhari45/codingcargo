package com.vc.hard;

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int si = 0; si <= m; si++) {
            for(int pi = 0; pi <= n; pi++) {
                if(si == 0 && pi == 0) {
                    //if length of input string si & input pattern pi is 0
                    dp[si][pi] = true;
                }
                else if(pi == 0) {
                    //if length of input pattern pi is 0
                    dp[si][pi] = false;
                }
                else if(si == 0) {
                    //if length of input string si is 0
                    //here pi will be > 0, so we have to handle special cases * and .
                    if(p.charAt(pi - 1) == '*') {
                        dp[si][pi] = dp[si][pi - 2];
                    }
                    else if(p.charAt(pi - 1) == '.') {
                        dp[si][pi] = false;
                    }
                    else {
                        dp[si][pi] = false;
                    }
                }
                else {
                    //if length of input string as well as input pattern is > 0
                    //here pi will be > 0, so we have to handle special cases * and .
                    if(p.charAt(pi - 1) == '*')  {
                        dp[si][pi] = dp[si][pi - 2];
                        if(p.charAt(pi - 2) == '.' || p.charAt(pi - 2) == s.charAt(si - 1)) {
                            dp[si][pi] |= dp[si - 1][pi];
                        }
                    }
                    else if(p.charAt(pi - 1) == '.') {
                        dp[si][pi] = dp[si - 1][pi - 1];
                    }
                    else if(p.charAt(pi - 1) == s.charAt(si - 1)) {
                        dp[si][pi] = dp[si - 1][pi - 1];
                    }
                    else {
                        dp[si][pi] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}