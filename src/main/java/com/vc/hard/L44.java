package com.vc.hard;

class L44 {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        this.dp = new int[s.length() + 1][p.length() + 1];
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++)
                dp[i][j] = -1;

        return solve(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean solve(char[] s, int si, char[] p, int pi) {
        if(si == s.length || pi == p.length) {
            if(si == s.length && pi == p.length) {
                dp[si][pi] = 1;
                return true;
            }

            if(si == s.length) {
                while(pi < p.length && p[pi] == '*') pi++;
                if(pi == p.length) {
                    dp[si][pi] = 1;
                    return true;
                }
                else {
                    dp[si][pi] = 0;
                    return false;
                }
            }
            else return false;
        }

        if(dp[si][pi] != -1) return dp[si][pi] == 1;

        boolean isMatch = false;
        if(p[pi] == '*') {
            //zero Match
            if(solve(s, si, p, pi + 1)) isMatch = true;

            //one Character Match
            if(solve(s, si + 1, p, pi + 1)) isMatch = true;

            //More than one character match
            if(solve(s, si + 1, p, pi)) isMatch = true;
        }

        if(p[pi] == '?' || p[pi] == s[si])
            isMatch = solve(s, si + 1, p, pi + 1);

        dp[si][pi] = isMatch ? 1 : 0;
        return isMatch;
    }
}