package com.vc.hard;

class ScrambleString {
    private int m;
    private Boolean[][][] dp;
    public boolean isScramble(String s1, String s2) {
        m = s1.length();
        dp = new Boolean[m][m][m];
        return dfs(s1, s2, 0, m - 1, 0, m - 1);
    }

    private boolean dfs(String s1, String s2, int l1, int r1, int l2, int r2) {
        if (l1 == r1) return s1.charAt(l1) == s2.charAt(l2);

        if (dp[l1][l2][r1 - l1] != null) return dp[l1][l2][r1 - l1];

        dp[l1][l2][r1 - l1] = false;
        //s1 = great s2 = rgeat
        for(int i = 0; i + l1 <= r1; i++) {
            dp[l1][l2][r1 - l1] = dp[l1][l2][r1 - l1] ||
                    //Check for length i
                    dfs(
                            s1, s2,
                            l1, l1 + i,                                 //g
                            l2, l2 + i                                  //r
                    ) &&
                            dfs(
                                    s1, s2,
                                    l1 + i + 1, r1,                     //reat
                                    l2 + i + 1, r2                      //geat
                            ) ||

                    //Check for length i, this time s2 in reverse
                    dfs(
                            s1, s2,
                            l1, l1 + i,                                 //g
                            r2 - i, r2                                  //t
                    ) &&
                            dfs(
                                    s1, s2,
                                    l1 + i + 1, r1,                     //reat
                                    l2, l2 + (r1 - l1 - i - 1)          //rgea
                            );

            if(dp[l1][l2][r1 - l1]) return true;
        }
        return dp[l1][l2][r1 - l1];
    }
}