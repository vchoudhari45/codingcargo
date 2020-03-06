package com.vc.hard;

class L10 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        for(int si = 0; si <= n; si++) {
            for(int pi = 0; pi <= m; pi++) {
                if(si == 0 && pi == 0) {
                    dp[si][pi] = true;
                }
                else if(si == 0) {
                    if(p.charAt(pi - 1) == '*') {
                        dp[si][pi] = dp[si][pi - 2];
                    }
                    else dp[si][pi] = false;
                }
                else if(pi == 0) {
                    dp[si][pi] = false;
                }
                else {
                    if(p.charAt(pi - 1) == '*') {
                        dp[si][pi] = dp[si][pi - 2];
                        if(p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                            dp[si][pi] |= dp[si - 1][pi];
                        }
                    }
                    else if(p.charAt(pi - 1) == '.' || p.charAt(pi - 1) == s.charAt(si - 1)) {
                        dp[si][pi] = dp[si - 1][pi - 1];
                    }
                    else dp[si][pi] = false;
                }
            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         if(dp[i][j])
        //             System.out.print("T ");
        //         else
        //             System.out.print("F ");
        //     }
        //     System.out.println();
        // }
        return dp[n][m];
    }
}